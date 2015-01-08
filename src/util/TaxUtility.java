package util;

import entity.Product;
import exception.TaxException;

import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TaxUtility {
	public static ArrayList<String> LoadFromFile() throws TaxException{
		int i = 0;
		String line = null;
		
		FileInputStream fileInput;
		ArrayList<String> array = new ArrayList<String>();
		
		try {
			fileInput = new FileInputStream(TaxConstants.TaxFile);
			array = new ArrayList<String>();
			BufferedInputStream buffIn = new BufferedInputStream(fileInput);
			BufferedReader buffRead = new BufferedReader(new InputStreamReader(buffIn));
		
			while ((line = buffRead.readLine()) != null){
				array.add(line);
				i++;
			}
			buffIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new TaxException("The File Is Not Found!");
		} catch (IOException e){
			e.printStackTrace();
			throw new TaxException("I/O ERROR!");
		}
		return array;
	}
	
	
	public static double calculateTotal(double[] total){
		double temp = 0.0;
		for(int i = 0; i < total.length; i++){
			temp = temp + total[i];
		}
		return temp;
	}
	
	public static double round(double value){
		DecimalFormat decimal = new DecimalFormat();
		double temp = Double.valueOf(decimal.format(value));
		return temp;
	}
	
	public static String getInputs(){
		String inputValue = null;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try{
			inputValue = buffer.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}
		return inputValue;
	}
	
	public static Product[] ParseInformation(String value, Product[] products, int index) throws TaxException{
		try{			
			String itemQuantity = value.substring(0, value.indexOf(TaxConstants.COMMA));
			String itemName = value.substring(value.indexOf(TaxConstants.COMMA)+1, value.lastIndexOf(TaxConstants.COMMA));
			String itemPrice = value.substring(value.lastIndexOf(TaxConstants.COMMA)+1, value.length());
		
			products[index] = new Product(itemName, Double.valueOf(itemPrice),Integer.valueOf(itemQuantity));
		}catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
			throw new TaxException("String index is out of range!");
		}
		return products;
	}

}
