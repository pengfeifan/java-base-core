package com.github.reflect;

public class PersonDaoImpl implements PersonDao{

	@Override
	public void insert() {
		System.out.println("insert person");		
	}

	@Override
	public void delete() {
		System.out.println("delete person");	
	}

}
