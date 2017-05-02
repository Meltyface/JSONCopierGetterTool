package interview.question;

import java.util.Arrays;
import java.util.List;

public class Main {
	// 11/4 TODO: Argument "phoneNumbers" does not return expected array

	public static void main(String[] args) {
		if (argsContainsASingleKeyword(args)) {
			String result = new ApplicationManager().delegateArgs(args);
			System.out.println(result);
			System.out.println("Program has completed");
		} else {
			printInstructions();
		}
	}

	private static boolean argsContainsASingleKeyword(String[] args) {
		List<String> argsAsList = Arrays.asList(args);
		boolean hasGet = argsAsList.contains("get");
		boolean hasCopy = argsAsList.contains("copy");
		return hasGet ^ hasCopy;
	}

	private static void printInstructions() {

		String i0 = "Program has up to three arguments.";
		String i1 = "First argument: 'copy', or 'get' (exclusive to each other)";
		String i2 = "'copy' stores the file for future access by the program";
		String i3 = "'get' option retrieves information from a file, given a file identifier key, and its JSON path";
		String i4 = "Second argument: file path, or file key.";
		String i5 = "With 'copy', provide a path to the file, relative to the working directory";
		String i6 = "With 'get', first give the '--id' or '-id' flags, followed by a file identifier key, which must be unique to each file, and corresponds to the id field in each file.";
		String i7 = "Third argument ('get' only): the path to the information to be retrieved";

		Arrays.asList(i0, i1, i2, i3, i4, i5, i6, i7).forEach(instruction -> {
			System.out.println(instruction);
		});

	}

}
