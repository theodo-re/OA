package cn.bdqn.oaproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//@EnableAutoConfiguration
@MapperScan("cn.bdqn.oaproject.dao")
public class OaprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(OaprojectApplication.class, args);
    }

}
