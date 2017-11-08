package jsonParse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GeoJsonFileUtils {

	public static String GeoJsonToString(File jsonFile) throws FileNotFoundException, IOException, ParseException {

		JSONParser jsonParser = new JSONParser();
		String data = jsonParser.parse(new FileReader(jsonFile)).toString();

		return data;
	}

}