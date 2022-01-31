package com.boot.server.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.server.exam.models.TblUser;

public interface UserRepository extends JpaRepository<TblUser,Long>{

	public TblUser findTblUserByUserName(String username);

}
