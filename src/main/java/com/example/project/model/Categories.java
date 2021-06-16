package com.example.project.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="categories")
public class Categories 
{

@Id

private int id;

public List<Categories> getList() {
	return list;
}


public void setList(List<Categories> list) {
	this.list = list;
}


@Column(name = "name",nullable = false,length = 50)
private String name;

@Column(name =  "active",nullable = false, length=1)
private String active;


@Column(name = "parent",nullable = true)
private int parent;

@Transient
private List<Categories> list;

public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getActive() {
	return active;
}


public void setActive(String active) {
	this.active = active;
}


public int getParent() {
	return parent;
}


public void setParent(int parent) {
	this.parent = parent;
}


@Override
public String toString() {
	return " [id=" + id + ", name=" + name + ", active=" + active +  "]";
}
}
