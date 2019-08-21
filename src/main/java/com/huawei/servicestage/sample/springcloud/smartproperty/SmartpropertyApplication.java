package com.huawei.servicestage.sample.springcloud.smartproperty;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.huawei.servicestage.sample.springcloud.smartproperty.dao.ResidenceDao;
import com.huawei.servicestage.sample.springcloud.smartproperty.model.Residence;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SmartpropertyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartpropertyApplication.class, args);
	}

    @Bean
    public CommandLineRunner loadData(ResidenceDao residenceDao) {
        return args -> {

        	residenceDao.save(new Residence("may", "p1", "l1"));
        	residenceDao.save(new Residence("jack", "p2", "l2"));
        	residenceDao.save(new Residence("john", "p3", "l3"));
        	
        	System.out.println("residence data loaded");
        };	
    }
}

