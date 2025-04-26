package com.rezoresb.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.List;

@AutoConfiguration //自動構成クラス
public class MyBatisAutoConfig {

    //SqlSessionFactoryBean
    //データベースに接続するためのデータソースを指定する必要がある。
    //pom.xmlファイルにspring-boot-starter-data-jdbcをdependencyに登録してある。
    //spring-boot-starter-data-jdbcは自動的にIOCコンテナにデータソースオブジェクトを作成する
    //よって、DataSource型の引数を渡せばよい。
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }


    //MapperScannerConfigure
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(BeanFactory beanFactory) {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();

        //スキャン対象パッケージ：スタータークラスのパッケージとその子パッケージ
        AutoConfigurationPackages.get(beanFactory);
        List<String> packages = AutoConfigurationPackages.get(beanFactory);
        String p = packages.get(0);
        mapperScannerConfigurer.setBasePackage(p);

        //スキャン対象アノテーション
        mapperScannerConfigurer.setAnnotationClass(Mapper.class);

        return mapperScannerConfigurer;
    }

}
