package com.bartcoder.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListTest {
	@Test
	public void testCallProperListSizeMock() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
		when(listMock.size()).thenReturn(3);
		assertEquals(3, listMock.size());
	}
	@Test
	public void testCallProperListSizeReturnMultiplevalueMock() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	@Test
	public void testListGetMethodMock() {
		@SuppressWarnings("unchecked")
		List<String> listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("nice");
		assertEquals(listMock.get(0), "nice");
	}
	@Test
	public void testListGetMethodMArgumentMatcherMock() {
		@SuppressWarnings("unchecked")
		List<String> listMock = mock(List.class);
		//Argument Matcher
		when(listMock.get(anyInt())).thenReturn("nice");
		assertEquals(listMock.get(0), "nice");
		assertEquals(listMock.get(1), "nice");
		assertEquals(listMock.get(2), "nice");
		assertEquals(listMock.get(3), "nice");
		
	}
	@Test(expected=RuntimeException.class)
	public void testListGetMethodMock_throwException() {
		List listMock = mock(List.class);
		//Argument Matcher
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
		assertEquals(listMock.get(0), "nice");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testArrayListSetMock() {
		List listMock = mock(ArrayList.class);
		when(listMock.set(0, "dodo")).thenReturn("Test");
		assertEquals(listMock.set(0, "dodo"), "Test");
	}
	
	/**
	 * Story: Returns go to stock
	 * In order to keep track of stock
	 * As a store owner
	 * I want to add items back to stock when they're returned.
	 * 
	 * Scenario 1: Refunded items should be returned to stock
	 * Given that a customer previously bought a black sweater from me
	 * And I have three black sweaters in stock
	 * When he returns the black sweater for a refund
	 * Then i should have four black sweaters in stock.
	 * 
	 * FORM - Given - (And) - When - Then
	  **/
	@Test
	public void test() {
		//BDDMockito - special class where we can write code more likely as an scenario
		//Given - setup
		
		//When - actual method call
		
		//Then - asserts
	}
	
	/** 
	 * Scenario 2: Replaced items should be returned to stock
	 * Given that a customer previously bought a blue garment from me
	 * And i have two blue garments in stock
	 * And three black garments in stock.
	 * When he returns the blue garment for a replacement in black
	 * Then i should have three blue garments in stock
	 * **/
	 
	
}
