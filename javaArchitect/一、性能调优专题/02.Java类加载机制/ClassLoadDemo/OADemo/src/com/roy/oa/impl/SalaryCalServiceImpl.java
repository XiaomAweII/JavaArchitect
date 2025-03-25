package com.roy.oa.impl;

import com.roy.oa.SalaryCalService;

public class SalaryCalServiceImpl implements SalaryCalService {
    @Override
    public Double cal(Double salary) {
        return salary * 2;
    }
}
