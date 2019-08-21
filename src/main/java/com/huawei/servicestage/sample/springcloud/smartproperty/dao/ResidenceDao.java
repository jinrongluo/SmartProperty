package com.huawei.servicestage.sample.springcloud.smartproperty.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.huawei.servicestage.sample.springcloud.smartproperty.model.Residence;

public interface ResidenceDao extends JpaRepository<Residence, Integer> {

	public Residence findByUserName(String userName);
}
