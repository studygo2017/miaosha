package com.imooc.miaosha;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@SpringBootApplication
public class MiaoshaApplication {


	public static void main(String[] args)
	{
		System.out.println("xxxxxxxxx");
		SpringApplication.run(MiaoshaApplication.class, args);
	}

}
