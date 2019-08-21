package com.huawei.servicestage.sample.springcloud.smartproperty.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("propertyinfo")
public interface PropertyInfoClient {

	@GetMapping(value="/properties/{propId}")
	String getPropertyInfo(@PathVariable(name="propId") String propId);
}
