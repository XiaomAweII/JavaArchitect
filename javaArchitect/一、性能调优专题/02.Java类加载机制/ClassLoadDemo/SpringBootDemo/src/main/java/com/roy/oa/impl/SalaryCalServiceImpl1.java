package com.roy.oa.impl;

import com.roy.oa.SalaryCalService;

public class SalaryCalServiceImpl1 implements SalaryCalService {
    @Override
    public Double cal(Double salary) {
        System.out.println("应该到手Money:" + salary);
        return salary;
    }
}
