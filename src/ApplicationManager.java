package interview.question;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ApplicationManager {
	private NewFileCreator writer = new NewFileCreator();
	private FileCopier fileReader = new FileCopier(writer);
	private JSONRepository repository = new JSONRepository();

	public String delegateArgs(String[] commands) {
		// Arg[0] will always be command word for type of action necessary.
		// Arg[0] can be copy, get
		try {
			List<String> commandsList = Arrays.asList(commands);

			if (commandsList.contains("get"))
				return get(commands);

			copy(commands);
			return "";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	private void copy(String[] commands) {
		String path = commands[1];
		fileReader.readFile(path);
	}

	private String get(String[] commands) {
		File file = null;
		for (int i = 0; i < commands.length; i++) {
			String arg = commands[i];
			if ("--id".equals(arg) || "-i".equals(arg)) {
				// Must use .equals for strings
				// When a string is created elsewhere, it won't have the same
				// address
				// .equals compares values in strings, == looks at memory
				// addresses.
				file = repository.identifyJSON(commands[i + 1]);
			}
		}
		if (file == null) {
			throw new RuntimeException("Could not find file.");
		}
		return new JSONReader().readJson(getKey(commands), file.getPath());
	}

	private String getKey(String[] commands) {
		for (int i = 1; i < commands.length; i++) {
			if ("-i".equals(commands[i]) || "--id".equals(commands[i])) {
				i += 1;
			} else {
				return commands[i];
			}
		}
		throw new RuntimeException("No JSON key given in command.");
		// TODO: if no key is given, return entire JSON
	}

}
