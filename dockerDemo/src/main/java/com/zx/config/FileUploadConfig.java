package com.zx.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

import static com.sun.deploy.util.BufferUtil.MB;

/**
 * @author zhangxin
 * @date 2022-10-22 11:04
 */
@Configuration
public class FileUploadConfig {
/*

    //@Bean
    public MultipartConfigElement multipartConfigElement() {
            MultipartConfigFactory factory = new MultipartConfigFactory();
        */
/*//*
/ 单个数据大小
        factory.setMaxFileSize(10MB); // KB,MB
        // 总上传数据大小
        factory.setMaxRequestSize(100MB);
        return factory.createMultipartConfig();*//*

    }
*/

}
