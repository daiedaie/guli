package com.guli.ucenter.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/11/17 15:15
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket adminApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("AdminApi")
                .apiInfo(ucenterApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();
    }

    private ApiInfo ucenterApiInfo(){

        return new ApiInfoBuilder()
                .title("用户中心API文档")
                .description("本文档描述了用户中心服务接口定义")
                .version("1.0")
                .contact(new Contact("kaixuan", "http://47.103.11.167/", "670973127@qq.com"))
                .build();
    }
}
