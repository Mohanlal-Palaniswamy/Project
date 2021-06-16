package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.Categories;

@Repository
public interface Repo extends CrudRepository<Categories, Integer>,JpaRepository<Categories, Integer>

{
	@Query(value = "SELECT * FROM Categories u WHERE u.parent = ?1", nativeQuery = true)
	List<Categories> findByParentId(Integer id);
}
