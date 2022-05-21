package cn.porsche.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"cn.porsche.demo", "cn.porsche.digital"})
@EnableDiscoveryClient
@EnableFeignClients
@ServletComponentScan(basePackages = "cn.porsche.digital.common.filter")
@SuppressWarnings("PMD")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
