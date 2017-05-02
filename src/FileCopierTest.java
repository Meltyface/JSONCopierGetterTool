package interview.question;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileCopierTest {
	FileCopier target;
	NewFileCreator writer = mock(NewFileCreator.class);
	
	@Before
	public void setup() {
		this.target = new FileCopier(writer);
	}
	
	@Test
	public void emptyStringTest() {
		checkFileInvalidity("");
	}
	
	@Test
	public void givenNonexistentPathTestInvalidity() {
		checkFileInvalidity("~/Documents/repository/Java_school/nonexistentfile.txt");
	}
	
	private void checkFileInvalidity(String path) {
		try {
			target.readFile(path);
			Assert.fail();
		} catch(Exception e) {
			assertTrue(e.getMessage().contains("Incorrect path input."));
		}
	}
	
	@Test
	public void writeToTxtTest() {
		target.readFile("touch.txt");
		verify(writer).create(any(String.class), any(String.class));
		// Verifies that the mock object 'writer' used the method 'create' with a string argument.
	}
}
