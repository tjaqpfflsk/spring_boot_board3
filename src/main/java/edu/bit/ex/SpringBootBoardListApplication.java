package edu.bit.ex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"edu.bit.ex.mapper"})
public class SpringBootBoardListApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBoardListApplication.class, args);
	}

}
