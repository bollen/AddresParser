package my.addressParser.test;

import my.addressParser.FileChooser;

import org.junit.Test;
import static org.junit.Assert.*;

public class AddressParser_AcceptanceTest {
/*
 * (5p) Skapa acceptancetest f�r projektet. 
 * Vi definierar acceptancetestet som f�ljande: G�r objekt av FileChooser, 
 * �ppna GUI:en, st�ng f�nstret, assert att f�nstret �ppnades och 
 * assert att f�nstret st�ngdes
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
