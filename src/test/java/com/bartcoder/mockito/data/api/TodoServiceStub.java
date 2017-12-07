package com.bartcoder.mockito.data.api;

import java.util.Arrays;
import java.util.List;

import com.bartcoder.data.api.TodoService;

public class TodoServiceStub implements TodoService {
	
	@Override
	public List<String> retriveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
	}
	@Override
	public String configureSetup(String user) {
		return null;
	}
	@Override
	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}
	
	

}