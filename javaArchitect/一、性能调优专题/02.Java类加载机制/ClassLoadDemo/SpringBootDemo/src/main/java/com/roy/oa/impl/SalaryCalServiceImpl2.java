package com.roy.oa.impl;

import com.roy.oa.SalaryCalService;

public class SalaryCalServiceImpl2 implements SalaryCalService {
    @Override
    public Double cal(Double salary) {
        salary = salary*2;
        System.out.println("实际到手Money:" + salary);
        return salary;
    }
}
