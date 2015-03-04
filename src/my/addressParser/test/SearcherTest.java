package my.addressParser.test;
import static org.junit.Assert.*;
import my.addressParser.Searcher;

import org.junit.*;

public class SearcherTest {
	
	@Test
	public void streetNumber(){
		Searcher s = new Searcher();
		String toTest = "TestStreet 11/12 ";
		String expected = "12 ";
		s.setInput_text(toTest);
		assertEquals(expected, s.streetNumber());
	}
	
	@Test
	public void flatNumber_String_expected(){
		Searcher s = new Searcher();
		String toTest = "TestStreet 11/12 ";
		String expected = "11";
		s.setInput_text(toTest);
		assertEquals(expected, s.flatNumber());
	}
	
	@Test
	public void streetName_String_expected(){
		Searcher s = new Searcher();
		String toTest = "TestStreet 11/12 ";
		String expected = "TestStreet ";
		s.setInput_text(toTest);
		assertEquals(expected, s.streetName());
	}

	@Test
	public void postCode_emptystring_null() {
		Searcher s = new Searcher();
		String test = "";
		s.setInput_text(test);
		assertNull(s.postCode());
	}
	
	@Test
	public void isPOBox_ValidPOBoxString_true(){
		Searcher s = new Searcher();
		String[] testStrings = {" BOX ", " box ", " Box "};
		for(String test : testStrings){
			s.setInput_text(test);
			assertTrue(s.isPOBox());
		}
	}
	
	@Test
	public void isLockedBag_ValidLockedBagString_true(){
		Searcher s = new Searcher();
		String[] testStrings = {" BAG ", " bag ", " Bag "};
		for(String test : testStrings){
			s.setInput_text(test);
			assertTrue(s.isLockedBag());
		}	
	}
	
	@Test
	public void postCode_validString_true() {
		Searcher s = new Searcher();
		String test = "3210";
		s.setInput_text(test);
		assertEquals(test, s.postCode());
	}
	
	@Test
	public void postCode_tooLong_True() {
		Searcher s = new Searcher();
		String test = "33100";
		s.setInput_text(test);
		assertNotEquals(test, s.postCode());
	}
	
	@Test
	public void streetType_streetNameWithType_expected() {
		Searcher s = new Searcher();
		String test = "Derpington Road";
		String expected = " Road";
		s.setInput_text(test);
		assertEquals(expected, s.streetType());
	}
	
	@Test
	public void streetType_streetNameWithOutType_null() {
		Searcher s = new Searcher();
		String test = "Derpstreet";
		s.setInput_text(test);
		assertNull(s.streetType());
	}
	
	@Test
	public void Address_ValidInput_expected() {
		Searcher s = new Searcher();
		String toTest = "Test Road 1 Box 3033";
		s.setInput_text(toTest);
		assertEquals("Test Road ", s.streetName());
		assertEquals(" 1 ", s.streetNumber());
		assertEquals("3033", s.postCode());
		assertTrue(s.isPOBox());
	}
}
