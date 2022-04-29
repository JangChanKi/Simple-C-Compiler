package automata;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Transition 클래스는 static 기반으로, main에서 한번 init 됩니다.
Table.json 파일에서 정의된 state 간의 transition을 불러옵니다.
이를 이용해 특정 table에서 input이 들어왔을 때 다음 state를 알 수 있고,
final state 여부를 확인할 수 있습니다.
이를 통해 DFA에서 state의 전환이 일어납니다.
 */

public class Transition {
    private static final int BUFFER_SIZE = 16 * 1024;
    public static JSONObject jsonTable;

    public static void init() {
        try {
            // read Table.json
            BufferedReader reader = new BufferedReader(
                    new FileReader("./table/Table.json"),
                    BUFFER_SIZE
            );

            // parse json file
            jsonTable = makeJsonTable(reader);


        } catch (IOException e) {
            System.out.println("[error] can not find Table.json");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("[error] not valid Table.json");
            e.printStackTrace();
        }
    }

    // Table.json 파일을 이용해 초기화
    @Nullable
    private static JSONObject makeJsonTable(BufferedReader reader) throws IOException, ParseException {
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
