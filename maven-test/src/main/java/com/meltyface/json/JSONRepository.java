package com.meltyface.json;

import java.io.File;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class JSONRepository {
	// JSON will be identified by Unix flag (i.e. --id, -i)
	public File identifyJSON(String id) {
		File[] fileList = new File(".").listFiles();
		for (File file : fileList) {
			String fileID;
			try {
				fileID = new JSONReader().getValue("id", file.getPath());
			} catch (IOException | ParseException e) {
				e.printStackTrace();
				throw new RuntimeException("Error reading file", e);
			}
			if (id.equals(fileID)) {
				return file;
			}
		}

		throw new RuntimeException("ID does not match a file");

	}
}
