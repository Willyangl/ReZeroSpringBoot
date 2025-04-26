package com.rezerosb.config;

import cn.itcast.pojo.Country;
import cn.itcast.pojo.Province;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    //CountryオブジェをBeanとして登録
    @Bean //メソッドの戻り値をIOCコンテナに管理させ、IOCコンテナのBeanオブジェクトとする
    public Country country(){
        return new Country();
    }

    //オブジェクトの暗黙な名前はメソッド名
    @Bean
    public Province province(){
        return new Province();
    }


}
