package util;

import java.util.ArrayList;

import entity.Product;
import exception.TaxException;

public class TaxCalculator {
	private Product product;
	
	public TaxCalculator(Product product){
		this.product = product;
	}
	
	public Product getProduct(){
		return this.product;
	}

	public double calculateBasicTax() throws TaxException{
		double basicTax = 0.0;
		boolean flag = false;
		
		ArrayList<String> basicItems = TaxUtility.LoadFromFile();
		for(int i=0; i < basicItems.size(); i++){
			if(product.getName().equalsIgnoreCase(basicItems.get(i))){
				flag = true;
				break;
			}
		}
		
		basicTax = (flag)? (product.getPrice() * TaxConstants.BASIC_TAX_PERCENTAGE)/100 : 0.0;
		
		System.out.println("Basic Tax: "+ basicTax);
		return basicTax;
		
	}
	
	public double calculateImportTax() throws TaxException{
		double ImportTax = 0.0;
		ImportTax = (product.getType().equalsIgnoreCase(TaxConstants.ISIMPORT) ) ? (product.getPrice() * TaxConstants.IMPORT_TAX_PERCENTAGE)/100 : 0.0;
		System.out.println("Extra Tax: "+ ImportTax);
		System.out.println("\n");
		return ImportTax;
	}
}
