package my.addressParser.test;

import my.addressParser.FileChooser;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;

public class AddressParser_AcceptanceTest {
/*
 * (5p) Skapa acceptancetest för projektet. 
 * Vi definierar acceptancetestet som följande: Gör objekt av FileChooser, 
 * Öppna GUI:en, stäng fönstret, assert att fönstret öppnades och 
 * assert att fönstret stängdes
 */
	@Test
	public void FileChooser_openGUI_guiOpen(){
		
		//create object for filechooser
		FileChooser fc = new FileChooser();
		assertNotNull(fc);
		
		//start and show gui
		fc.createAndShowGUI();
		//assert gui is visible
		assertTrue(fc.frame.isVisible());
		
		//close the window
		fc.frame.dispose();
		//assert that the window is no longer visible
		assertFalse(fc.frame.isVisible());
	}
}
