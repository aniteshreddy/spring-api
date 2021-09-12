package com.anitesh.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anitesh.bean.UserAccount;


@Repository
public interface UserDao extends JpaRepository<UserAccount,Integer>{
	@Query("from UserAccount where email=:email and password=:password")
	public UserAccount getUserByPassword(@Param("email")String email,@Param("password")String password);
	
}
