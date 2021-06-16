package com.example.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Categories;
import com.example.project.repository.Repo;

@RestController
public class MyController 
{
	
@Autowired
Repo repo; 
	
@GetMapping
public String forAll()
{
	return "hello";
}


@PostMapping("/save")
public String save(@RequestBody Categories category)
{
	repo.save(category);
	return "saved";
}

@PutMapping("/update")
public String update(@RequestBody Categories category)
{
	repo.save(category);
	return "updated successfully";
}



@GetMapping("/getbyid")
public Categories getbyid(@RequestParam int id)
{
	Optional<Categories> list=repo.findById(id);
	return list.get();
}



@GetMapping("/getbyparentid")
public List<Categories> getbyparentid(@RequestParam int id) 
{
	List<Categories> list = new ArrayList<>();

	try 
	{
		list = repo.findByParentId(id);
	} 
	catch (Exception e) 
	{
		System.out.println(e.getMessage());
	}
	return list;
}


@GetMapping("/gettree")
public List<Categories> getTree()
{
	List<Categories> list = new ArrayList<>();
	try
	{
		list=repo.findByParentId(0);
		for(Categories c:list)
		{
			List<Categories> sub =new ArrayList<>();
			sub=repo.findByParentId(c.getId());
			c.setList(sub);
		}
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	return list;
}




}
