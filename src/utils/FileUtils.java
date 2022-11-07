package utils;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileUtils {
    public static JSONArray ReadJsonFile(String file_path) throws ParseException, IOException {
        JSONParser parser = new JSONParser();

        try {
            return (JSONArray) parser.parse(new FileReader(file_path));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public static void WriteJsonFile(String file_path, JSONArray accounts) {
        //Write JSON file
        try (FileWriter file = new FileWriter(file_path)) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(accounts.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
