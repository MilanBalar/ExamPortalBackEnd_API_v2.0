package com.boot.server.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.server.exam.models.TblRoles;

public interface RoleRepository extends JpaRepository<TblRoles, Long>{

}
