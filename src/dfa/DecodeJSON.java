package dfa;

import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DecodeJSON {
    private JSONObject table;
    private JSONParser parser = new JSONParser();
    
    public DecodeJSON(){
        try{
            InputStream l = getClass().getResourceAsStream("/dfa/DFATable.json");
            table = (JSONObject) parser.parse(new InputStreamReader(l));
        } catch (Exception error){
            System.out.println(error);
        }
    }

    public JSONObject getTable(int tableNum){
        String tableID = Integer.toString(tableNum);
        JSONObject parsedTable = (JSONObject) table.get(tableID);
        return parsedTable;
    }

}
