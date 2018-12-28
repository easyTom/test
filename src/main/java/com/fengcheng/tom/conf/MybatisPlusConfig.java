package com.fengcheng.tom.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

/**
 * Created by Roy on 2018-03-29.
 */
@Configuration
@MapperScan(basePackages = {"com.fengcheng.mapper*"})
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        paginationInterceptor.setLocalPage(true);
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }
}
