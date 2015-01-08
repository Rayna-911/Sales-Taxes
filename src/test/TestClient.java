package test;

import junit.framework.TestCase;

import org.junit.Before;

import entity.Batch;
import entity.Product;
import entity.Receipt;
import exception.TaxException;
import util.TaxConstants;
import util.TaxUtility;


public class TestClient extends TestCase{

	Batch salesBatch;
	Product[] products;
	
	@Before
	public void setUp() throws Exception {
		salesBatch = new Batch();
	}

	public void testInput1()throws TaxException{
		System.out.println("Input 1:");
		System.out.println("1 book at 12.49");
		System.out.println("1 music CD at 14.99");
		System.out.println("1 chocolate bar at 0.85");
		
		String[] value = {"1,book,12.49","1,music,14.99","1,chocolate,0.85"};
		String itemType =TaxConstants.ISLOCAL;
		salesBatch.setSize(Integer.valueOf(3));
		products = new Product[salesBatch.getSize()];
		salesBatch.setProducts(products);
		
		for(int i = 0;i<salesBatch.getSize();i++){
			basicProcessing(value[i],itemType,i);
			System.out.println("Item Price: "+ products[i].getTotalWithoutTax() + " Total tax: "+ products[i].getTotalTax() + " Total price: " + products[i].getTotal());
		}
		System.out.println("Receipt:");
		Receipt.generateReceipt(products, salesBatch);
	}
	
	public void testInput2() throws TaxException{
		System.out.println("Input 2:");
		System.out.println("1 imported box of chocolates at 10.00");
		System.out.println("1 imported bottle of perfume at 47.50");
		String[] value = {"1,chocolate,10.00","1,perfume,47.50"};
		
		String itemType =TaxConstants.ISIMPORT;
		salesBatch.setSize(Integer.valueOf(2));
		products = new Product[salesBatch.getSize()];
		salesBatch.setProducts(products);
		
		for(int i = 0;i<salesBatch.getSize();i++){
			basicProcessing(value[i],itemType,i);
			System.out.println("Item Price: "+ products[i].getTotalWithoutTax() + " Total tax: "+ products[i].getTotalTax() + " Total price: " + products[i].getTotal());
		}
		System.out.println("Receipt:");
		Receipt.generateReceipt(products, salesBatch);
		
	}

	public void testInput3() throws TaxException{
		System.out.println("Input 3:");
		System.out.println("1 imported bottle of perfume at 27.99");
		System.out.println("1 bottle of perfume at 18.99");
		System.out.println("1 packet of headache pills at 9.75");
		System.out.println("1 box of imported chocolates at 11.25");
		
		String[] value = {"1,perfume,27.99","1,perfume,18.99","1,pills,9.75","1,chocolate,11.25"};
		String itemType =TaxConstants.ISIMPORT;
		salesBatch.setSize(Integer.valueOf(4));
		products = new Product[salesBatch.getSize()];
		salesBatch.setProducts(products);
		
		for(int i = 0;i<salesBatch.getSize();i++){
			basicProcessing(value[i],itemType,i);
			System.out.println("Item Price: "+ products[i].getTotalWithoutTax() + " Total tax: "+ products[i].getTotalTax() + " Total price: " + products[i].getTotal());
		}
		System.out.println("Receipt:");
		Receipt.generateReceipt(products, salesBatch);		
	}
	
	private void basicProcessing(String value, String itemType, int index) throws TaxException{
		products = TaxUtility.ParseInformation(value,products,index);
		products[index].setType(itemType);
		products[index].setTax(products[index].getTotalTax());

		salesBatch.setOneItem(products[index].getTotal(),index);
		salesBatch.setOneTax(products[index].getTax(),index);
	}
}
