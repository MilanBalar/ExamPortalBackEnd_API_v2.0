package com.boot.server.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.server.exam.models.exammodel.TblCategories;

public interface CategoryRepository extends JpaRepository<TblCategories, Long> {

}
