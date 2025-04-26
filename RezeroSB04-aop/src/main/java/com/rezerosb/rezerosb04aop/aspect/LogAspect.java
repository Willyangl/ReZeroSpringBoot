package com.rezerosb.rezerosb04aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

@Component
@Aspect
public class LogAspect {

    // serviceは以下の全メソッドの実行前に組み込みメソッドを実行
    @Before("execution(* com.rezerosb.rezerosb04aop.service..*.*(..))")
    //組み込むメソッド
    public void sysLog(JoinPoint jp) {
        StringJoiner log = new StringJoiner("|", "{", "}");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        log.add(formatter.format(LocalDateTime.now()));

        //メソッド名を取得
        String methodName = jp.getSignature().getName();
        log.add(methodName);

        Object[] args = jp.getArgs();
        for (Object arg : args) {
            log.add(arg == null ? "-" : arg.toString());
        }
        System.out.println("ログ：" + log.toString());
    }
}