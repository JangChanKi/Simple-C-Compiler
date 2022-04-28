package automata;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Table {
    private static final int BUFFER_SIZE = 16 * 1024;

    public Table() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("Table.json"),
                    BUFFER_SIZE
            );
            makeJsonTable(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void makeJsonTable(BufferedReader reader) throws IOException{
        JSONParser jsonParser = new JSONParser();

        String str = "";
        String nextLine;
        while ((nextLine = reader.readLine()) != null) {
            str += nextLine;
        }


        try {
            JSONObject obj = (JSONObject) jsonParser.parse(str);
            System.out.println(obj);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
