package test;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Test;

import util.TaxConstants;

public class TestTaxConstants extends TestCase{

	@Test
	public void testConstants() {
		assertEquals(TaxConstants.ISIMPORT,"IMPORT");
		assertEquals(TaxConstants.ISLOCAL,"LOCAL");
		assertEquals(TaxConstants.BASIC_TAX_PERCENTAGE,10);
		assertEquals(TaxConstants.IMPORT_TAX_PERCENTAGE,5);
		
		assertEquals(TaxConstants.TaxFile,new File("F:\\taxFile.txt"));
		
		assertEquals(TaxConstants.MAX_SIZE,20);
		assertEquals(TaxConstants.COMMA,',');
		assertEquals(TaxConstants.Y,"Y");
	}

}
