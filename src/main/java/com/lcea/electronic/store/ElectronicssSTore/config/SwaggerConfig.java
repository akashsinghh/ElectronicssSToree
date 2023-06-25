//package com.lcea.electronic.store.ElectronicssSTore.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.ArrayDeque;
//
//@Configuration
//public class SwaggerConfig {
//    @Bean
//    public Docket docket(){
//        Docket docket=new Docket(DocumentationType.SWAGGER_2);
//        docket.apiInfo(getApiInfo());
//        return docket;
//    }
//
//    private ApiInfo getApiInfo() {
//        ApiInfo apiInfo =new ApiInfo("Electronic Store Backend: APIS",
//                "This is backend course",
//                "1.0.0V",
//                "https://www.learncodewithakash.com",
//                new Contact("Akash","https://wwww.instagram.com/dugresh_k_t",
//                        "learncodewithdurgesh@gmail.com",
//                        "License of APIS",
//                        "https://www.learncodewithakash.com/about",
//                        new ArrayDeque<>()));
//        return apiInfo;
//    }
//}
