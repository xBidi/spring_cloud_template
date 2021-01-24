package com.spring.turbine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableTurbine
@EnableDiscoveryClient
@RestController
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Value("${redirect.url}")
  private String redirectUrl;

  @GetMapping("/")
  public void turbine(HttpServletResponse response) throws IOException {
    response.sendRedirect(redirectUrl);
  }
}
