package com.dwproject.emp;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestMethodOrder;


public class TestEmployee {
	
	@Test
	@Disabled
	public void testSave() {
		System.out.println("save");
	}
	
	@Test
	@Tag("dev")
	public void testUpdate() {
		System.out.println("update");
	}
	
	@Test
	@Tag("prod")
	public void testDelete() {
		System.out.println("delete");
	}

}
