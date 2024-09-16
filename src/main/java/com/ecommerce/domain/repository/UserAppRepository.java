package com.ecommerce.domain.repository;




import com.ecommerce.domain.entity.UserApp;
import com.ecommerce.domain.entity.key.UserAppKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserAppRepository extends CrudRepository<UserApp, UserAppKey> {
    UserApp findUserAppByUserCode(Integer userCode) throws Exception;
}
