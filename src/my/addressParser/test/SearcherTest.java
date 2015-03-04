package my.addressParser.test;
import static org.junit.Assert.*;
import my.addressParser.Searcher;

import org.junit.*;

public class SearcherTest {
	
	//@Test
	/* new searcher
	 * streetnumber		(^|\\s|/)\\d{1,4}\\s
	 * flatnumber		d{1,4}/
	 * streettype		s[a-zA-Z]{2,}$
	 * streetname		D{4,}
	 * suburb			\\s|,\\s|\\d{4},\\s|\\d{4}\\s)*[a-zA-Z]{4,}$
	 * postcode			3\\d{3}
	 * isPObox			\\s(B|b)(O|o)(x|X)\\s
	 * isLockedBag		\\s(B|b)(A|a)(G|g)\\s
	 * finder
	 * 
	 * the addresses that we look for should be in the following format:
	 * FLATNUMBER	0-9999
	 * 	
	 * 
	 */
	
	@Test
	public void streetNumber(){
		Searcher s = new Searcher();
		String address = "TestStreet 11/12";
		String expected = "12";
		s.setInput_text(address);
		s.streetName();
		s.flatNumber();
		//assertEquals(s.streetNumber(), expected);
	}
	
	/*@Test
	public void StreetNumber_emptyString_null(){
		String test = "";
		Searcher s = new Searcher();
		s.setInput_text(test);
		assertNull(s.streetNumber());
	}
	
	@Test
	public void StreetNumber_number_number(){
		String test = "1234";
		Searcher s = new Searcher();
		s.setInput_text(test);
		assertEquals(s.streetNumber(), test);
	}
	
	@Test
	public void StreetNumber_string_null(){
		String test = "abcd";
		Searcher s = new Searcher();
		s.setInput_text(test);
		assertNull(s.streetNumber());
		
	}
	*/
	@Test
	public void postCode_emptystring_null() {
		Searcher s = new Searcher();
		String test = "";
		s.setInput_text(test);
		assertNull(s.postCode());
	}
	
	@Test
	public void RegexTestIsPOBox_ValidPOBoxString_true(){
		Searcher s = new Searcher();
		String[] testStrings = {" BOX ", " box ", " Box "};
		for(String test : testStrings){
			s.setInput_text(test);
			assertTrue(s.isPOBox());
		}
	}
	
	@Test
	public void RegexTestIsLockedBag_ValidLockedBagString_true(){
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
		assertTrue(s.postCode() == test);
	}
	
	@Test
	public void postCode_tooLong_True() {
		Searcher s = new Searcher();
		String test = "33100";
		s.setInput_text(test);
		assertFalse(s.postCode() == test);
	}
}
