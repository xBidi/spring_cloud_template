package com.spring.zuul;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ErrorFilter extends ZuulFilter {
  private static final Logger LOG = LoggerFactory.getLogger(ErrorFilter.class);

  private static final String FILTER_TYPE = "error";
  private static final String THROWABLE_KEY = "throwable";
  private static final int FILTER_ORDER = -1;

  @Override
  public String filterType() {
    return FILTER_TYPE;
  }

  @Override
  public int filterOrder() {
    return FILTER_ORDER;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @SneakyThrows
  @Override
  public Object run() {
    final RequestContext context = RequestContext.getCurrentContext();
    final Object throwable = context.get(THROWABLE_KEY);

    if (throwable instanceof ZuulException) {
      final ZuulException zuulException = (ZuulException) throwable;
      LOG.error("Zuul failure detected: " + zuulException.getMessage());

      // remove error code to prevent further error handling in follow up filters
      context.remove(THROWABLE_KEY);

      ObjectMapper objectMapper = new ObjectMapper();
      String timestamp = new Timestamp(System.currentTimeMillis()).toString();
      int status = HttpStatus.SERVICE_UNAVAILABLE.value();
      String error = HttpStatus.SERVICE_UNAVAILABLE.name();
      String message = zuulException.getMessage();
      String path = context.getRequest().getRequestURI();
      ErrorResponse errorResponse = new ErrorResponse(timestamp, status, error, message, path);
      // populate context with new response values
      context.setResponseBody(objectMapper.writeValueAsString(errorResponse));
      context.getResponse().setContentType("application/json");
      // can set any error code as excepted
      context.setResponseStatusCode(503);
    }
    return null;
  }
}
