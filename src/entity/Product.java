package entity;

import exception.TaxException;
import util.TaxCalculator;

public class Product {
	private String name;
	private double price;
	private int quantity;
	private String type;
	private double tax;
	private TaxCalculator calculator;
	 
	public Product(String name, double price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		
		calculator = new TaxCalculator(this);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public void setTax(double tax){
		this.tax = tax;
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public int getQuantity(){
		return this.quantity;
	}

	public String getType(){
		return this.type;
	}

	public double getTax(){
		return this.tax;
	}
	
	public double getTotalWithoutTax(){
		return (this.getPrice() * this.getQuantity());
	}
	
	public double getTotal(){
		return (this.getTotalWithoutTax() + this.getTax());
	}

	public double getTotalTax() throws TaxException{
		return (calculator.calculateBasicTax() + calculator.calculateImportTax());
	}
}
