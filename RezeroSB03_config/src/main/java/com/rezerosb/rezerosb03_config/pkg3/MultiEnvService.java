package com.rezerosb.rezerosb03_config.pkg3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MultiEnvService {

    @Value("${myapp.memo}")
    private String memo;

    public void print(){
        System.out.println(memo);
    }
}
