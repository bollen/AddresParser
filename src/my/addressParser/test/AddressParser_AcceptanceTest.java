package my.addressParser.test;

import my.addressParser.FileChooser;

import org.junit.Test;
import static org.junit.Assert.*;

public class AddressParser_AcceptanceTest {

	@Test
	public void FileChooser_openGUI_guiOpen(){
		
		//create object for filechooser
		FileChooser fc = new FileChooser();
		assertNotNull(fc);
		
		//start and show gui
		FileChooser.createAndShowGUI();
		//assert gui is visible
		assertTrue(FileChooser.frame.isVisible());
		
		//close the window
		FileChooser.frame.dispose();
		//assert that the window is no longer visible
		assertFalse(FileChooser.frame.isVisible());
	}
}
