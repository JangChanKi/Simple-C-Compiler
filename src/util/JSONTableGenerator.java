package util;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONTableGenerator {

    private static final int BUFFER_SIZE = 16 * 1024;

    private final String fileName;

    private final BufferedReader reader;

    public JSONTableGenerator(final String fileName) throws FileNotFoundException {
        this.fileName = fileName;

        this.reader = new BufferedReader(
                new FileReader(fileName),
                BUFFER_SIZE
        );
    }

    @Nullable
    public JSONObject getJSONTable() {

        JSONObject res = null;
        try {
            JSONParser jsonParser = new JSONParser();

            // read json file
            String str = "";
            String nextLine;
            while ((nextLine = reader.readLine()) != null) {
                str += nextLine;
            }

            // parse json file
            res = (JSONObject) jsonParser.parse(str);
        } catch (IOException e) {
            System.out.println("error : IO exception from " + fileName);
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("error : can not parse json file from " + fileName);
            e.printStackTrace();
        }

        return res;
    }

}
