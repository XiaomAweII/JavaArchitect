package com.roy;

import com.roy.oa.SalaryCalService;

import java.util.ServiceLoader;

public class SPITest {
    public static void main(String[] args) {
        ServiceLoader<SalaryCalService> services = ServiceLoader.load(SalaryCalService.class);
        for (SalaryCalService service : services) {
            System.out.println(service.cal(10000.00));
        }
    }
}
