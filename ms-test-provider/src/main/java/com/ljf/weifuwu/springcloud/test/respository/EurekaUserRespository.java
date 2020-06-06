package com.ljf.weifuwu.springcloud.test.respository;




import com.ljf.weifuwu.springcloud.test.model.Eurekauser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EurekaUserRespository extends JpaRepository<Eurekauser, Long> {
}


