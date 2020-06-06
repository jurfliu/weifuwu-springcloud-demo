package com.ljf.weifuwu.springcloud.ribbon.repository;

import com.ljf.weifuwu.springcloud.ribbon.model.EurekaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EurekaUserRespository extends JpaRepository<EurekaUser, Long> {
    }


