package com.meltyface.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Ignore;
import org.junit.Test;

import com.meltyface.Main;

public class CopyJSONTest {
	private static final String TEXT_FOLDER = "src/test/resources/text_files_for_testing/";
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd--HH-mm");
	
	@Test
	public void copyAndRelocateTest() throws Exception {
		// System tests (often written by product owner) are high-level
		// Behaviour-driven development

		String longTestFile = TEXT_FOLDER + "example0.json";
		assertCopied(longTestFile);
	}
	
	
	@Test
	public void invalidPathTest() {
		try {
			Main.main(new String[] { "copy", "dfgdf", "jqaxc" });
		} catch (RuntimeException e) {
			assertEquals("Incorrect path input. Run again with correct file path.", e.getMessage());
		}
	}

	private void assertCopied(String testFilePath) throws IOException {
		String timePoint = LocalDateTime.now().format(FORMATTER); 
		String outputPath = "./" + timePoint;
		Main.main(new String[] { "copy", testFilePath, outputPath });
		assertTrue(compareFiles(testFilePath, outputPath));
	}

	private Boolean compareFiles(String sourcePath, String destPath) throws IOException {
		String contentSource = new String(Files.readAllBytes(Paths.get(sourcePath)));
		String contentDest = new String(Files.readAllBytes(Paths.get(destPath)));
		return contentSource.equals(contentDest);
	}

}
