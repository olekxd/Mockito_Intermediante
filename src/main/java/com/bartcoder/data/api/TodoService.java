package com.bartcoder.data.api;

import java.util.List;

//Create TodoServiceStub
//Test TodoBusinessImpl using TodoServiceStub
public interface TodoService {

	public List<String> retriveTodos(String user);
	
	public String configureSetup(String user);
	
	public void deleteTodo(String todo);
}
