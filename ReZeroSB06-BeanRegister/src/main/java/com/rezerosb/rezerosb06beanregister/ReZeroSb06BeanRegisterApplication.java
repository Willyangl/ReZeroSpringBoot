package com.rezerosb.rezerosb06beanregister;

import cn.itcast.pojo.Country;
import com.rezerosb.config.CommonImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CommonImportSelector.class)
public class ReZeroSb06BeanRegisterApplication {
    public static void main(String[] args) {

        //登録したBeanを確認するためのコード
        ApplicationContext context = SpringApplication.run(ReZeroSb06BeanRegisterApplication.class, args);
        Country country = context.getBean(Country.class);
        System.out.println(country);

        System.out.println(context.getBean("province"));
    }
}
