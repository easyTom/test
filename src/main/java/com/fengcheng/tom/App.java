package com.fengcheng.tom;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.fengcheng.tom.util.SpringContextProvider;



/**
 * Created by Tom on 2018-05-21.
 */
@SpringBootApplication
@Import(SpringContextProvider.class)
public class App {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        System.err.println("一大波僵尸即将来袭~");
    }
}
//Cannot determine embedded database driver class for database type NON
//无法确定数据库类型的嵌入式数据库驱动程序类

