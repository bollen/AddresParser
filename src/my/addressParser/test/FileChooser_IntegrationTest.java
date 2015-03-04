package my.addressParser.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import my.addressParser.FileChooser;

import org.junit.Test;

public class FileChooser_IntegrationTest {

	@Test
	public void OpenFile_ValidFile_FileOpened() throws FileNotFoundException, IOException {
		
		FileChooser fc = new FileChooser();
		String path = System.getProperty("user.dir") 
				+ File.separator 
				+ "src" + File.separator;
		
		File outputFile = new File(path + "addresses.csv");
		File inputFile = new File(path + "testaddress.txt");
		
		try { outputFile.delete(); } catch(Exception e) {}
		System.out.println("Current dir: " + path);
		
		assertFalse(outputFile.exists());
		fc.parseFile(inputFile);
		assertTrue(outputFile.exists());
	}
	
	@Test (expected = FileNotFoundException.class)
	public void OpenFile_NoFile_Exception() throws FileNotFoundException, IOException {
		
		FileChooser fc = new FileChooser();
		String path = System.getProperty("user.dir");
		File inputFile = new File(path + "\\src/invalidfile.txt");
		
		fc.parseFile(inputFile);
		assertFalse(inputFile.exists());
	}
}
