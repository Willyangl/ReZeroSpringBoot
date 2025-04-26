package com.rezerosb.rezerosb04aop.service.impl;

import com.rezerosb.rezerosb04aop.service.SomeService;
import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public void query(Integer id) {
        System.out.println("SomeServiceのビジネスロジック:Query");
    }

    @Override
    public void save(String name, Integer age) {
        System.out.println("SomeServiceのビジネスロジック:Save");
    }
}
