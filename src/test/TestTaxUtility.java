package test;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import entity.Product;
import exception.TaxException;
import util.TaxUtility;
import util.TaxConstants;

public class TestTaxUtility extends TestCase{

	@Test
	public void testLoadFromFile() {
		try {
			ArrayList<String> arr; 
			arr = TaxUtility.LoadFromFile();
			assertNotNull(arr);
		} catch (TaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	public void testcalculateTotal0() {
		double[] total = new double[3];
		total[0] = 1.2;
		total[1] = 1.00;
		total[2] = 0.101;
		double temp = TaxUtility.calculateTotal(total);
		assertEquals(TaxUtility.round(temp),2.301);		
	}
	
	@Test
	public void testcalculateTotal1() {
		double[] total1 = new double[22];
		total1[0] = 1.2;
		total1[1] = 1.00;
		total1[2] = 0.101;
		double temp1 = TaxUtility.calculateTotal(total1);
		assertEquals(TaxUtility.round(temp1),2.301);		
	}
	
	@Test
	public void testRound() {
		assertEquals(TaxUtility.round(12.49956788898),12.5);
		assertEquals(TaxUtility.round(1.49999),1.5);
		assertEquals(TaxUtility.round(11),11.0);
		assertEquals(TaxUtility.round(0.123411),0.123);
		assertEquals(TaxUtility.round(0.000011),0.0);
		assertEquals(TaxUtility.round(0.249811),0.25);
		assertEquals(TaxUtility.round(0.299811),0.3);
		assertEquals(TaxUtility.round(0.2829800000002),0.283);
	}
	
	@Test
	public void testPrarseInformation() {
		try {
			Product[] product;
			product = TaxUtility.ParseInformation("1,book,23.45", new Product[4], 0);
			assertEquals(product[0].getName(), "book");
			assertEquals(product[0].getPrice(), 23.45);
			assertEquals(product[0].getQuantity(), 1);
		} catch (TaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
