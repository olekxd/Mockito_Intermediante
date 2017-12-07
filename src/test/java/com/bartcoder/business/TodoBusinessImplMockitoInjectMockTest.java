package com.bartcoder.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bartcoder.data.api.TodoService;
@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMockTest {

	// What is mocking?
	// mocking is creating objects that simulate the behavior or real objects.
	// Unlike stubs, mocks can be dynamically created from code - at runtime. 
	// Mocks offer more functionality than stubbing.
	// You can verify method call and a lot of other things	
	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl; 
	@Test
	public void testRetriveListSizeTodos_usingMock() {
		List<String> todo = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");

		when(todoServiceMock.retriveTodos("Dummy")).thenReturn(todo);
		List<String> filteredTodos = todoBusinessImpl.retriveTodosRelatedToSpring("Dummy"); 
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testRetriveEmptyListWithTodoMock() {
		List<String> emptyList = Arrays.asList("");
		
		//Here i create a mock 
		when(todoServiceMock.retriveTodos("Gary")).thenReturn(emptyList);
		
		//And here is given my mock into a object from TodoBusinessImpl.class
		List<String> filteredTodos = todoBusinessImpl.retriveTodosRelatedToSpring("Gary");
		
		assertEquals(0, filteredTodos.size());
	}
	
	@Test
	public void testRetriveFalseAuthorizationMock() {
		//Given
		String falseAuth = "false";
		given(todoServiceMock.configureSetup("Nico")).willReturn(falseAuth);
		//When
		boolean falseFAuth = todoBusinessImpl.haveUserAuthorization("Nico");
		//Then
		assertThat(falseFAuth, is(false));		
	}
	
	
	@Test
	public void testRetriveListSizeTodos_usingBDD() {
		
		//Given - willReturn
		//Given - always point a setup in a code e.g i setting mock for return a particular list with element
		List<String> todo = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");
		given(todoServiceMock.retriveTodos("Dummy")).willReturn(todo);
		//When - thenReturn
		//When - SUT - System under test, a part where e.g. is actual method is called 
		List<String> filteredTodos = todoBusinessImpl.retriveTodosRelatedToSpring("Dummy");
		
		//Then - result 
		assertThat(filteredTodos.size(), is(2));
	}
	
	@Test
	public void testDeleteElementsNotRelatedToSpringMock_usingBDD() {
		//Given
		List<String> todo = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance", "Learn to dance");
		given(todoServiceMock.retriveTodos("Tom")).willReturn(todo);
		//When
		todoBusinessImpl.retriveTodosNotRelatedToSpring("Tom");
		//Then
		verify(todoServiceMock, times(2)).deleteTodo("Learn to dance");
		verify(todoServiceMock, never()).deleteTodo("Damn");
		verify(todoServiceMock, never()).deleteTodo("WoopWoop");
		
		
	}
	
	@Test
	public void testDeleteElementsNotRelatedToSpringMock_usingBDDAlternative() {
		//Given
		List<String> todo = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance", "Learn to dance");
		given(todoServiceMock.retriveTodos("Tom")).willReturn(todo);
		//When
		todoBusinessImpl.retriveTodosNotRelatedToSpring("Tom");
		//Then
		then(todoServiceMock).should(times(2)).deleteTodo("Learn to dance");
		//In this example, we capture a String argument. In real world projects, we use it to capture more complex objects
		then(todoServiceMock).should(never()).deleteTodo("Damn");
		then(todoServiceMock).should(never()).deleteTodo("WoopWoop");	
	}
	
	@Test
	public void testDeleteElementsNotRelatedToSpringMock_usingBDDAlternative_CapturinArguments() {
		//Declare Argument Captor
		ArgumentCaptor<String> stringArgumentCapture = ArgumentCaptor.forClass(String.class);
		//Given
		List<String> todo = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance", "Learn to dance");
		given(todoServiceMock.retriveTodos("Tom")).willReturn(todo);
		//When
		todoBusinessImpl.retriveTodosNotRelatedToSpring("Tom");
		//Then
		//Define Argument Captor on specific method call
		//Capture the argument
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCapture.capture());
		//In this example, we capture a String argument. In real world projects, we use it to capture more complex objects
		assertThat(stringArgumentCapture.getValue(), is("Learn to dance"));
	}
}