package automata;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Transition {
    private static final int BUFFER_SIZE = 16 * 1024;
    public static JSONObject jsonTable;

    public Transition() {
        try {
            // read Table.json
            BufferedReader reader = new BufferedReader(
                    new FileReader("./src/table/Table.json"),
                    BUFFER_SIZE
            );

            // parse json file
            jsonTable = makeJsonTable(reader);


        } catch (IOException e) {
            System.out.println("[error] Table.json 파일을 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("[error] Table.json 파일의 형식이 잘못되었습니다.");
            e.printStackTrace();
        }
    }

    // Table.json 파일을 이용해 초기화
    @Nullable
    private JSONObject makeJsonTable(BufferedReader reader) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        String str = "";
        String nextLine;
        while ((nextLine = reader.readLine()) != null) {
            str += nextLine;
        }

        JSONObject obj = (JSONObject) jsonParser.parse(str);
        return obj;
    }

    // curState 에서 input이 들어왔을 때 다음 state
    @Nullable
    public static String getNextState(String tableName, String curState, String input) {
        JSONObject table = (JSONObject) jsonTable.get(tableName);

        JSONObject current = (JSONObject) table.get(curState);
        return (String) current.get(input);
    }

    // state가 final인지
    public static boolean isFinalState(String tableName, String state) {
        return "true".equals(((JSONObject) ((JSONObject) jsonTable.get(tableName)).get(state)).get("final"));
    }

}
