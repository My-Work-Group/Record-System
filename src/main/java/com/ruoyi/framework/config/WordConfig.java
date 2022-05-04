package com.ruoyi.framework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintStream;

/**
 * @Author: 庞沛东
 * @Description: word模板相关配置
 * @Date: create in 2022/5/4 13:59
 */

@Component
@Configuration
@RestController
public class WordConfig {

    /**
     * word模板路径
     */
    @Value("${word.path}")
    private  static String  path;

    public static void main(String[] args) {
        System.out.println(WordConfig.path);
    }
//
//    public  String getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        this.path = path;
//    }


    //    public static String path;
//
//    public static String  getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        WordConfig.path= path;
//    }
}
