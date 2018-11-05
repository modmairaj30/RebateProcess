package com.dalmia.dce.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.valuedge.scsc.entities.OTP;
import com.valuedge.scsc.entities.User;
import com.valuedge.scsc.vo.UserVO;


public interface UserRepository extends JpaRepository<User,String>{

	//Optional<User> findByUserName(String userName);

	Optional<User> findByEmailId(String emailId);

	Optional<User> findByMobileNo(String mobileNo);

	Optional<User> findByUserName(UserVO userName);

	Optional<User> findByUserName(String userName);
	
	Optional<User> findByMobileNo(OTP mobileNo);
	
}
