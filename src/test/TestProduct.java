package test;

import junit.framework.TestCase;

import org.junit.Test;

import entity.Product;

public class TestProduct extends TestCase{

	Product product;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		product = new Product("book",12.49,1);
		product.setType("IMPORTED");
	}
	
	@Test
	public void testsetName(){
		product.setName("Food");
		assertEquals(product.getName(),"Food");
		product.setName("123");
		assertEquals(product.getName(),"123");
		product.setName("");
		assertEquals(product.getName(),"");
		product.setName(null);
		assertEquals(product.getName(),null);
		product.setName("book");
		assertEquals(product.getName(),"book");
	}
	
	@Test
	public void testsetPrice(){
		product.setPrice(13.00);
		assertEquals(product.getPrice(),13.00);
		product.setPrice(13.9999);
		assertEquals(product.getPrice(),13.9999);
		product.setPrice(12.49);
		assertEquals(product.getPrice(),12.49);
	}
	
	@Test
	public void testsetQuantity(){
		product.setQuantity(3);
		assertEquals(product.getQuantity(),3);
		product.setQuantity(0);
		assertEquals(product.getQuantity(),0);
		product.setQuantity(1);
		assertEquals(product.getQuantity(),1);
	}
	
	@Test
	public void testsetType(){
		product.setType("LOCAL");
		assertEquals(product.getType(),"LOCAL");
		product.setType("123");
		assertEquals(product.getType(),"123");
		product.setType("IMPORTED");
		assertEquals(product.getType(),"IMPORTED");
	}

	@Test
	public void testsetTax(){
		product.setTax(3.00);
		assertEquals(product.getTax(),3.00);
		product.setTax(3.9999);
		assertEquals(product.getTax(),3.9999);
		product.setTax(0.0);
		assertEquals(product.getTax(),0.0);
	}

	@Test
	public void testgetName(){
		assertNotNull(product.getName());
		assertEquals(product.getName(),"book");
	}

	@Test
	public void testgetPrice(){
		assertNotNull(product.getPrice());
		assertEquals(product.getPrice(),12.49);
	}

	@Test
	public void testgetQuantity(){
		assertNotNull(product.getQuantity());
		assertEquals(product.getQuantity(),1);
	}

	@Test
	public void testgetType(){
		assertNotNull(product.getType());
		assertEquals(product.getType(),"IMPORTED");
	}

	@Test
	public void testgetTax(){
		assertNotNull(product.getTax());
		assertEquals(product.getTax(),0.0);
	}
}
