package my.addressParser.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidObjectException;

import my.addressParser.FileChooser;

import org.junit.Test;

public class FileChooser_IntegrationTest {
	
 /*
  * (10p) Skapa integrationstest för programmet. 
  * Gör ett integrationstest för en riktig fil som skall lyckas att köras 
  * och ett integrationstest för en fil som inte finns.
  */
	@Test
	public void OpenFile_ValidFile_FileOpened() throws FileNotFoundException, IOException {
		
		FileChooser fc = new FileChooser();
		String path = System.getProperty("user.dir");
		File outputFile = new File(path +"\\src/addresses.csv");
		File inputFile = new File(path + "\\src/testaddress.txt");
		
		try { outputFile.delete(); } catch(Exception e) {}
		//System.out.println("Current dir: " + path);
		
		assertFalse(outputFile.exists());
		fc.parseFile(inputFile);
		assertTrue(outputFile.exists());
	}
	
	@Test (expected = InvalidObjectException.class)
	public void OpenFile_NoFile_Exception() throws FileNotFoundException, IOException {
		
		FileChooser fc = new FileChooser();
		String path = System.getProperty("user.dir");
		File inputFile = new File(path + "\\src/invalidfile.txt");
		
		fc.parseFile(inputFile);
	}
}
