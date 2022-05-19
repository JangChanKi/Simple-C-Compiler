package syntax;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import org.json.simple.JSONObject;
import util.JSONTableGenerator;
import java.io.*;

/*
The LRTable class initially needs to init once for file IO.
Reads the transitions of items defined in the LRTable.json file.
s[num] : shift and goto state # num
r[num] : reduce by production # num
[num] : goto state # num
acc : accept
epsilon treats it as 'e', and rejects if there is no transition corresponding to the input in json.
 */
public class LRTable {

    public static final String FILE_NAME_LR_TABLE = "." + File.separator + "table" + File.separator + "LRTable.json";
    public static final String FILE_NAME_PROD = "." + File.separator + "table" + File.separator + "Production.json";

    private static JSONObject lrTable;

    private static JSONObject productions;

    public static void init() throws FileNotFoundException {
       // json file
        JSONTableGenerator lrTableGenerator = new JSONTableGenerator(FILE_NAME_LR_TABLE);       // LR Table
        JSONTableGenerator lhsGenerator = new JSONTableGenerator(FILE_NAME_PROD);                // LHS of productions

        lrTable = lrTableGenerator.getJSONTable();
        productions = lhsGenerator.getJSONTable();
    }

    @Nullable
    public static String getAction(final int curState, final String input) {
        JSONObject state = (JSONObject) lrTable.get(""+curState);

        return (String) state.get(input);
    }

    @NotNull
    public static int getGoto(final int curState, final String input) {
        JSONObject state = (JSONObject) lrTable.get(""+curState);
        String res = (String) state.get(input);

        if (isNumber(res))
            return Integer.parseInt(res);
        return -1;
    }

    @Nullable
    public static String getLHS(final int prodNum) {
        JSONObject prod = (JSONObject) productions.get(""+prodNum);
        return (String) prod.get("LHS");
    }

    @Nullable
    public static long getNumOfRHS(final int prodNum) {
        JSONObject prod = (JSONObject) productions.get(""+prodNum);
        return (Long) prod.get("RHS");
    }

    private static boolean isNumber(String str) {
        for (int i=0; i<str.length(); i++)
            if (!('0' <= str.charAt(i) && str.charAt(i) <= '9'))
                return false;
        return true;
    }

}
