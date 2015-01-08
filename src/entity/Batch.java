package entity;

import util.TaxConstants;
import util.TaxUtility;

public class Batch {
	private double[] items = new double[ TaxConstants.MAX_SIZE ]; 
	private double[] taxes = new double [ TaxConstants.MAX_SIZE ];

	private Product[] products;
	private int size;
	
	public double getTotalItems(){
		return TaxUtility.calculateTotal(items);
	}
	
	public double getTotalTaxes(){
		return TaxUtility.calculateTotal(taxes);
	}
	
	public double getSum(){
		return getTotalItems() + getTotalTaxes();
	}

	public Product getProducts(int index){
		return products[index];
	}
	
	public int getSize(){
		return this.size;
	}
	
	public double getOneItem(int index){
		return items[index];
	}
	
	public double getOneTax(int index){
		return taxes[index];
	}
	
	public void setProducts(Product[] products){
		this.products = products;
	}
	
	public void setSize(int size){
		this.size = size;
	}

	public void setOneItem(double total, int index){
		this.items[index] = total;
	}
	
	public void setOneTax(double total, int index){
		this.taxes[index] = total;
	}
	
	public double getOneTotal(int index){
		return (getOneItem(index) + getOneTax(index));
	}
}
