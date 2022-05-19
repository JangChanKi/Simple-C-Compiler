package lexical;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import util.JSONTableGenerator;

import java.io.*;

/*
Transition 클래스는 static 기반으로, main에서 한번 init 됩니다.
TokenTable.json 파일에서 정의된 state 간의 transition을 불러옵니다.
이를 이용해 특정 table에서 input이 들어왔을 때 다음 state를 알 수 있고,
final state 여부를 확인할 수 있습니다.
이를 통해 DFA에서 state의 전환이 일어납니다.
 */

public class Transition {

    public static final String FILE_NAME = "." + File.separator + "table" + File.separator + "TokenTable.json";

    private static JSONObject jsonTable;

    public static void init() throws FileNotFoundException {
        // json file
        JSONTableGenerator jsonTableGenerator = new JSONTableGenerator(FILE_NAME);

        jsonTable = jsonTableGenerator.getJSONTable();
    }

    // curState 에서 input이 들어왔을 때 다음 state
    @Nullable
    public static String getNextState(final String tableName, final String curState, final String input) {
        JSONObject table = (JSONObject) jsonTable.get(tableName);

        JSONObject current = (JSONObject) table.get(curState);
        return (String) current.get(input);
    }

    // state가 final인지
    public static boolean isFinalState(final String tableName, final String state) {
        return "true".equals(((JSONObject) ((JSONObject) jsonTable.get(tableName)).get(state)).get("final"));
    }

}
