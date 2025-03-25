package com.roy;

import com.roy.oa.SalaryCalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.support.SpringFactoriesLoader;

@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        double salary = 10000.00;
        //SpringBoot自己实现了 SPI 机制，为什么还要传入一个 ClassLoader ？
        SpringFactoriesLoader.loadFactories(SalaryCalService.class, null)
                .forEach(salaryCalService -> {
                    System.out.println(salaryCalService.cal(salary));
        });
    }
}
