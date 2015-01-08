package test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import util.TaxUtility;
import entity.Batch;
import entity.Product;

public class TestBatch extends TestCase{
	Batch batch;
	Product[] product;
	
	@Before
	public void setUp() throws Exception {
		batch = new Batch();
		product = new Product[4];
	}

	@Test
	public void testgetSum(){
		double[] items = new double[5];
		double[] taxes = new double[5];
		double item = TaxUtility.calculateTotal(items);
		double tax = TaxUtility.calculateTotal(taxes);
		double sum = batch.getSum();
		assertNotNull(sum);
		assertEquals(sum,item+tax);
	}

	@Test
	public void testgetProducts(int index){
		product[0] = new Product("book",112.49,1);
		batch.setProducts(product);
		assertNotNull(batch.getProducts(0));
	}

	@Test
	public void testgetSize(){
		batch.setSize(100);
		assertNotNull(batch.getSize());
		assertEquals(batch.getSize(),100);
		batch.setSize(0);
		assertNotNull(batch.getSize());
		assertEquals(batch.getSize(),0);
	}

	@Test
	public void testgetOneItem(){
		batch.setOneItem(12.00,1);
		assertNotNull(batch.getOneItem(1));
		assertEquals(batch.getOneItem(1),12.00);
		batch.setOneItem(12.999909,2);
		assertNotNull(batch.getOneItem(2));
		assertEquals(batch.getOneItem(2),12.999909);
	}

	@Test
	public void testgetOneTax(){
		batch.setOneTax(1.2,1);
		assertNotNull(batch.getOneTax(1));
		assertEquals(batch.getOneTax(1),1.2);
		batch.setOneTax(0.90,2);
		assertNotNull(batch.getOneTax(2));
		assertEquals(batch.getOneTax(2),0.90);
	}

	@Test
	public void testsetProducts(){
		product[0] = new Product("book",112.49,1);
		batch.setProducts(product);
		assertNotNull(batch.getProducts(0));
	}

	@Test
	public void testgetOneTotal(){
		batch.setOneItem(12.38, 0);
		batch.setOneTax(1.238, 0);
		assertNotNull(batch.getOneTotal(0));
		assertEquals(batch.getOneTotal(0),12.38+1.238);
	} 
}
