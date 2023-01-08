package com.dwproject.DemoJunit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class TestCalculator {
	
	Calculator c = null;
	
	
//	@Mock
//	CalculatorService service;
	
//	@Rule public MockitoRule rule = MockitoJUnit.rule();
	
	CalculatorService service = Mockito.mock(CalculatorService.class);
	@Test // bcz of this annotation junit known it is a test case method
	public void testAdd() {	
		when(service.add(2, 3)).thenReturn(5);
		assertEquals(10, c.perform(2, 3));
		verify(service).add(2, 3);
	}

	
	@Before // this method get called before every test method
	public void setUp() {
		c = new Calculator(service);
		System.out.println("it execute before every test method");
	}
	
	@After // this method get called after every test method
	public void closeThings() {
		c = null;
		System.out.println("it execute after every test method");
	}
	
	 @BeforeClass
	 public static void beforeClass() {
	    System.out.println("this method is execute only once before this test class");
	 }
	 
	 @AfterClass
	 public static void afterClass() {
	    System.out.println("this method is execute only once after this test class");
	 }
	
	
	@Test
	public void testAllTheMethodsOfAssertions() {
		List<String> todos = Arrays.asList("Junit","Mockito");
		assertEquals(2,todos.size()); // it checks the expected and actul values  if both are same  test pass
		assertEquals(4, todos.size(), 2); // it has 3 params, expected , actual and delta/difference 
		assertTrue(2>1); // it checks the condition if condition is True test pass
		assertFalse(2<1); // it checks the condition if condition is False test pass
		assertNotNull(todos);  // it checks the list is null or not if not null test pass
		ArrayList<String> list = null;
		assertNull(list); // it checks the list is null or not if null test pass
		String str1 = "ravi";
		String str2 = "ravi";
		String str3 = "sai ganesh";
		assertSame(str1, str2); // both strings refer the same object that's why it's true
		assertNotSame(str3, str2);// both str3 & str2 refer different object that's why it's true
		String[] expectedArray = {"ravi", "sai ganesh", "pavan"};
		String[] resultArray =  {"ravi", "sai ganesh", "pavan"};
		assertArrayEquals(expectedArray, resultArray); // it checks the two arrays if both have same values test pass	
	}
	
	 @Test // it will work for multiple then_return  
     public void testList_Returns_MultipleValues() {  
		 
//		 when(service.add(3, 4)).thenReturn(7).thenReturn(8);
//		 assertEquals(7, 7);
//		 assertEquals(8, 8);
//		 verify(service);
       
		 List mocklist = mock(List.class);  
		 when(mocklist.size()).thenReturn(1).thenReturn(2).thenReturn(3);   
		 assertEquals(1, mocklist.size());   
		 assertEquals(2, mocklist.size());  
		 assertEquals(3, mocklist.size());   
       
     }
	 
	 @Test   // we can use get method also when we apply mock on list.
     public void testList_get(){  
		 List mocklist = mock(List.class);  
		 when(mocklist.get(0)).thenReturn("Mockito");  
		 assertEquals("Mockito", mocklist.get(0)); 
		 verify(mocklist);
	 }
	 
	 
	 
	 @Test  // spy() method allows us to keep track of what is happening with the real object as well as allow us to overrides a specific behavior.
	 public void testSpy() {     
	      List spyArrayList = spy(ArrayList.class);  
	      assertEquals(0, spyArrayList.size());   
	      spyArrayList.add("Mockito");  
	      assertEquals(1, spyArrayList.size());
	      spyArrayList.add(0,"hi");
	      assertEquals("hi", spyArrayList.get(0));
	 }  
	  
	 
	 @Test(expected = RuntimeException.class)  
     public void testList_ThrowsException() {   
		 List<String> mocklist = mock(List.class);  
		 when(mocklist.get(Mockito.anyInt())).thenThrow(new RuntimeException("Error.."));  
		 mocklist.get(0);  
     } 
}