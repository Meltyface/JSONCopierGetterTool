package interview.question;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

public class NewFileCreator {

	private static final String fileAlreadyExistsMessage = "File already exists. Change file name.";

	public void create(String filename, String fileData) {
		try {
			Path file = Paths.get(filename);
			Files.write(file, fileData.getBytes(), WRITE, TRUNCATE_EXISTING, CREATE);
		} catch (IOException e) {
			throw new RuntimeException(fileAlreadyExistsMessage, e);
		}
	}


}
