package interview.question;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	
	private static final List<Class<?>> JSON_TYPES = Arrays.asList(String.class, JSONObject.class, Boolean.class, Number.class, JSONArray.class);
	
	
	public String readJson(String key, String pathToJSON) {

		try {
			return getValue(key, pathToJSON);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getValue(String key, String path) throws IOException, ParseException, FileNotFoundException {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));

		Object value = jsonObject.get(key);
		if (isToStringable(value)) {
			return value.toString();
		}
		
		return "";
	}

	private boolean isToStringable(Object value) {
		for (Class<?> c: JSON_TYPES) 
			if (c.isInstance(value))
				return true;
		return false;
	}
	
}
