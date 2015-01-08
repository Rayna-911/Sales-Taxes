package entity;

import util.TaxUtility;

public class Receipt {
	public static void generateReceipt(Product[] product, Batch batch){
		System.out.println("----------------------------------------------WELCOME-------------------------------------------------------");
		System.out.println("\tQuantity\tItem\t\tPrice\t\tTotal\t\tTax\t\tTotal Price");
	
		System.out.println("------------------------------------------------------------------------------------------------------------");
		for(int i =0;i<product.length;i++){
			System.out.println("\t"+product[i].getQuantity()+
							   "\t\t"+product[i].getName()+
							   "\t"+(product[i].getName().length() > 7 ? "" : "\t")+
							   TaxUtility.round(product[i].getPrice())+
							   "\t\t"+TaxUtility.round(product[i].getTotalWithoutTax())+
							   "\t\t"+TaxUtility.round(product[i].getTax())+
							   "\t\t"+TaxUtility.round(product[i].getTotal()));
		}
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t      Sales Tax Total : " + TaxUtility.round(batch.getTotalTaxes()));
		System.out.println("\t\t\t\t\t\t\t\t\t        Total : " + TaxUtility.round(batch.getSum()));
	}
}
