package my.addressParser.test;
import static org.junit.Assert.*;
import my.addressParser.Searcher;

import org.junit.*;

public class SearcherTest {
	
	//@Test
	/* new searcher
	 * streetnumber
	 * flatnumber
	 * streettype
	 * streetname
	 * suburb
	 * postcode
	 * isPObox
	 * isLockedBag
	 * finder
	 */
	
	@Test
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
	

}
