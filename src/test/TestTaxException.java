package test;

import junit.framework.TestCase;

import org.junit.Test;

import exception.TaxException;

public class TestTaxException extends TestCase{

	@Test
	public void test() {
		assertNotNull(new TaxException());
	}
	@Test
	public void testString(){
		assertNotNull(new TaxException("Testing"));
	}

}
