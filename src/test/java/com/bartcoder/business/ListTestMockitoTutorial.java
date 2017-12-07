package com.bartcoder.business;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.LinkedList;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class ListTestMockitoTutorial {
	
	@Test(expected=RuntimeException.class)
	public void simpleFirstMockExample() {
		 //You can mock concrete classes, not just interfaces
		 LinkedList mockedList = mock(LinkedList.class);
		 //stubbing
		 when(mockedList.get(0)).thenReturn("first");
		 //following prints "first"
		 when(mockedList.get(1)).thenThrow(new RuntimeException("Error"));
		 //following throws runtime exception
//		 System.out.println(mockedList.get(0));
		 System.out.println(mockedList.get(1));
		 //following prints "null" because get(999) was not stubbed
		 //Although it is possible to verify a stubbed invocation, usually it's just redundant
		 //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
		 //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
		 verify(mockedList).get(1);
//		 verify(mockedList).get(1);
		
	}
	
	
	//Verification of the same numbers of invocations 
	@Test
	public void verifyExactNumberOfInvocations() {
		List mockedList = mock(List.class);
		mockedList.add("uno");
		//following two verifications work exactly the same - times(1) is used by default
		verify(mockedList).add("uno");
		verify(mockedList, times(1)).add("uno");
		 
		mockedList.add("duo");
		mockedList.add("duo");
		
		mockedList.add("tres");
		mockedList.add("tres");
		mockedList.add("tres");
		
		verify(mockedList, never()).add("punto");
		
		verify(mockedList, times(2)).add("duo");
		verify(mockedList, times(3)).add("tres");
	}
	
	//Stubbing void methods with exceptions
	@Test(expected= RuntimeException.class)
	public void stubbingVoidMethodsWithExceptions() {
		List mockedList = mock(List.class);
		doThrow(new RuntimeException()).when(mockedList).clear();
		mockedList.clear();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testInOrderVerificationSingle() {
		List singleMock = Mockito.mock(List.class);
		singleMock.add("first");
		singleMock.add("second");
		
		InOrder inOrder = inOrder(singleMock);
		
		inOrder.verify(singleMock).add("first");
		inOrder.verify(singleMock).add("second");
	}
	
	
	

}
