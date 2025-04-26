package com.rezerosb.rezerosb04aop;

import com.rezerosb.rezerosb04aop.service.SomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RezeroSb04AopApplicationTests {

    @Autowired
    private SomeService someService1;
    @Autowired
    private SomeService someService2;

    @Test
    void testLog() {
        someService1.query(1001);
        someService1.save("Willyang",20);

        someService2.query(999);
        someService2.save("Test2",99);
    }
}
