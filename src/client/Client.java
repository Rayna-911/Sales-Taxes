package client;

import util.TaxConstants;
import util.TaxUtility;
import entity.Batch;
import entity.Product;
import entity.Receipt;
import exception.TaxException;

public class Client {
	public static void main(String[] args){
		String NumOfItems = "";
		String ItemType = "";
		String value = "";
		
		Batch batch = new Batch();
		
		try{
			System.out.println("How many items have you bought? Please enter the number: ");
			NumOfItems = TaxUtility.getInputs();
			Product[] products = new Product[batch.getSize()];
		
			batch.setSize(Integer.valueOf(NumOfItems));
			batch.setProducts(products);
		
			for(int i = 0; i < batch.getSize(); i++){
				System.out.println("Please enter the items in the format of 'Quantity,Item,Price' :");
				value = TaxUtility.getInputs();
				products = TaxUtility.ParseInformation(value, products, i);
			
				System.out.println("Import or Not? Y/N");
				ItemType = TaxUtility.getInputs();
				products[i].setType(ItemType.equalsIgnoreCase(TaxConstants.Y)? TaxConstants.ISIMPORT:TaxConstants.ISLOCAL);
				products[i].setTax(products[i].getTotalTax());
			
				batch.setOneItem(products[i].getTotalWithoutTax(), i);
				batch.setOneTax(products[i].getTax(), i);
			
				System.out.println("Item Price: "+ products[i].getTotalWithoutTax() + " Total tax: "+ products[i].getTotalTax() + " Total price: " + products[i].getTotal());
			}		
			Receipt.generateReceipt(products, batch);
		}catch(TaxException e){}
	}
}
