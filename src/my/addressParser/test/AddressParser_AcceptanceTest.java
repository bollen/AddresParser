package my.addressParser.test;

import my.addressParser.FileChooser;

import org.junit.Test;

import static org.junit.Assert.*;


public class AddressParser_AcceptanceTest {
/*
 * (5p) Skapa acceptancetest för projektet. 
 * Vi definierar acceptancetestet som följande: Gör objekt av FileChooser, 
 * öppna GUI:en, stäng fönstret, assert att fönstret öppnades och 
 * assert att fönstret stängdes
 */
	@Test
	public void FileChooser_openGUI_guiOpen(){
		FileChooser fc = new FileChooser();
		assertNotNull(fc);
		fc.createAndShowGUI();
		assertTrue(fc.isVisible());
		fc.frame.dispose();
		//FIXME: assert window closed
		//assertNull(fc);
		//assertFalse(fc.isVisible());
	}
}
