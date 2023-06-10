package com.LW1_ptlb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient//nacos 发现服务
@EnableFeignClients//feign 调用服务
@SpringBootApplication
public class CommunicatePtlbApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunicatePtlbApplication.class, args);
    }

}
