package interview.question;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GetJSONTest {	
	ApplicationManager target = new ApplicationManager();
	
	@Before
	public void setUp() {
		copyExampleFile(0);
		copyExampleFile(1);
		copyExampleFile(2);
	}
		
	@Test
	public void findNametest() {
		findX("firstName", "John");
	}
	
	@Test
	public void findAddresstest() {
		findX("address", "{\"streetAddress\":\"21 2nd Street\",\"city\":\"New York\",\"postalCode\":\"10021-3100\",\"state\":\"NY\"}");
	}
	
	@Test
	public void findNumbertest() {
		findX("age", "25");
	}
	
	@Test
	public void findBooltest() {
		findX("isAlive", "true");
	}
	
	private void findX(String key, String expected) {
		assertEquals(expected, target.delegateArgs(new String[] {"get", key, "--id", "example0"}));
	}
	
	private void copyExampleFile(int i) {
		target.delegateArgs(new String[] {"copy", "text_files_for_testing/example" + i + ".json"});
	}
	
}
