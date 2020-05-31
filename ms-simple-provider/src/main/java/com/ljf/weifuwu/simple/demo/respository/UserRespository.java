package com.ljf.weifuwu.simple.demo.respository;

import com.ljf.weifuwu.simple.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface UserRespository extends JpaRepository<User, Long> {
    }


