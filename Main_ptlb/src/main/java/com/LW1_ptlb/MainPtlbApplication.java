package com.LW1_ptlb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient//用于注册上去的服务发现
@EnableFeignClients//用于 Feigin 调用 nacos 服务
@SpringBootApplication
public class MainPtlbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainPtlbApplication.class, args);
    }

}
