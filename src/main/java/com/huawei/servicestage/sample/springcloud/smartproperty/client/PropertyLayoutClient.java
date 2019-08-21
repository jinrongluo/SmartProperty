package com.huawei.servicestage.sample.springcloud.smartproperty.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("propertylayout")
public interface PropertyLayoutClient {

	@GetMapping(value="/layouts/{layoutId}")
	String getPropertyLayout(@PathVariable(name="layoutId") String layoutId);
}
