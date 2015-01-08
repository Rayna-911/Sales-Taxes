package test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import util.TaxCalculator;
import util.TaxConstants;
import util.TaxUtility;
import entity.Product;
import exception.TaxException;

public class TestTaxCalculator extends TestCase{
	
	Product product;
	TaxCalculator taxCalculator;
	
	@Before 
	public void setUp() throws Exception{
		product = new Product("book",12.29,1);
		taxCalculator = new TaxCalculator(product);
	}
	
	@Test
	public void testCalculator(){
		assertNotNull(taxCalculator);
	}
	
	@Test
	public void testCalculateBasicTax(){
		double val;
		product.setType(TaxConstants.ISLOCAL);
		try {
			val = taxCalculator.calculateBasicTax();
			assertEquals(val,0.0);
		}catch(TaxException e){}
	}

	@Test
	public void testCalculateImportTax(){
		double val;
		product.setType(TaxConstants.ISIMPORT);
		try {
			val = taxCalculator.calculateImportTax();
			assertEquals(TaxUtility.round(val),TaxUtility.round(12.28*0.05));
		}catch(TaxException e){}
	}
}
