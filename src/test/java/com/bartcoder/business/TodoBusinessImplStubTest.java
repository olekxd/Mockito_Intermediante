package com.bartcoder.business;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.bartcoder.data.api.TodoService;
import com.bartcoder.mockito.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {
	
	private TodoService todoServiceStub = new TodoServiceStub();
	 TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
	List<String> filteredTodos = todoBusinessImpl.retriveTodosRelatedToSpring("Dummy"); 
	@Test
	public void testRetriveListSizeTodos_usingAStub() {
//		TodoService todoServiceStub = new TodoServiceStub();
//		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
//		List<String> filteredTodos = todoBusinessImpl.retriveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testRetriveListSizeTodos_usingAStub2() {
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testRetriveTodosObjectRelatedToSpring_usingAStub() {
		List<String> expectedOutput = Arrays.asList("Learn Spring MVC", "Learn Spring");
		assertEquals(expectedOutput, filteredTodos);	
	}
	
	

}
