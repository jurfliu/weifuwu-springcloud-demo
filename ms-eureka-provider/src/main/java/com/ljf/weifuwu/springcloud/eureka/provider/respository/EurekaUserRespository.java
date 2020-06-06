package com.ljf.weifuwu.springcloud.eureka.provider.respository;

import com.ljf.weifuwu.springcloud.eureka.provider.model.EurekaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EurekaUserRespository extends JpaRepository<EurekaUser, Long> {
    }


