package com.rezerosb.rezerosb03_config.pkg2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ReadConfig {
    @Autowired
    private Environment environment;

    public void print() {
        String name = environment.getProperty("app.name");
        if (environment.containsProperty("app.owner")) {
            System.out.println("app.owner =" + environment.getProperty("app.owner"));
        }
        Integer port = environment.getProperty("app.port", Integer.class, 9009);

        String str = String.format("name=%s, port=%d", name, port);
        System.out.println("str = " + str);
    }
}