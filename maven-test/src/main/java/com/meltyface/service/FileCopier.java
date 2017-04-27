package com.meltyface.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileCopier {
	private NewFileCreator writer;
	
	public FileCopier(NewFileCreator writer) {
		this.writer = writer;
	}
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd--HH-mm");
	
	private static final String fileNotFoundMessage = "Incorrect path input. Run again with correct file path.";
	
	public void readFile(String path) {		
		String fileData = validate(path);
		String timePoint = LocalDateTime.now().format(FORMATTER); 
		String newFilePath = "./" + timePoint;
		writer.create(newFilePath, fileData);
	}

	private String validate(String path) {
		try {
			return new String(Files.readAllBytes(Paths.get(path)));			
		} catch(IOException e) {
			// IOException is checked exception
			throw new RuntimeException(fileNotFoundMessage + " Was given path: " + Paths.get(path).toAbsolutePath().toString());
		}
	}
	
}
