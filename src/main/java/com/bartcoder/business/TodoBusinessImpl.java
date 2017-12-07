package com.bartcoder.business;

import java.util.ArrayList;
import java.util.List;

import com.bartcoder.data.api.TodoService;

//TodoBusinessImpl SUT 
//(Dependency - TodoService) - because TodoBusinessImpl is depend from TodoService
public class TodoBusinessImpl {
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	public List<String> retriveTodosRelatedToSpring(String user){
		List<String> filteredTodos = new ArrayList<>();
		List<String>todos = todoService.retriveTodos(user);
		
		for(String todo: todos) {
			if(todo.contains("Spring")){
				filteredTodos.add(todo); 
				}
		}
		return filteredTodos;
	}

	public void retriveTodosNotRelatedToSpring(String user){
		List<String>todos = todoService.retriveTodos(user);
		
		for(String todo: todos) {
			if(!todo.contains("Spring")){
				todoService.deleteTodo(todo);; 
				}
		}	
	}
	
	
	public boolean haveUserAuthorization(String user) {
		String authorizedUser = todoService.configureSetup(user);
		if(authorizedUser.equals("authorized"))
			return true;
		else 
			return false;
	}
	
	
}
