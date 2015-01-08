package test;

import junit.framework.TestCase;

import org.junit.Test;

import entity.Batch;
import entity.Product;
import entity.Receipt;

public class TestReceipt extends TestCase{

	@Test
	public void test() {
		Receipt.generateReceipt(new Product[0], new Batch());
	}
}
