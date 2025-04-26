package com.rezerosb.rezerosb03_config;

import com.rezerosb.rezerosb03_config.pkg1.SomeService;
import com.rezerosb.rezerosb03_config.pkg2.ReadConfig;
import com.rezerosb.rezerosb03_config.pkg3.MultiEnvService;
import com.rezerosb.rezerosb03_config.pkg4.AppBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RezeroSb03ConfigApplicationTests {

    @Autowired
    private SomeService someService;

    @Test
    void test01() {
        someService.printValue();
    }

    @Autowired
    private ReadConfig readConfig;

    @Test
    void test02() {
        readConfig.print();
    }

    @Autowired
    private MultiEnvService service;

    @Test
    void test03(){
        service.print();
    }

    @Autowired
    private AppBean appBean;

    @Test
    void test04(){
        System.out.println("appBean = " + appBean.toString());
    }
}
