package lexical;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
인식된 토큰을 테이블 파일로 저장하기 위한 structure
해당 lexeme에서 오류가 발생했을 경우 errorOccur를 활성화시켜서
그 이후의 출력을 중지시킬 수 있습니다.
 */

public class Token {
    private final String tokenName;
    private final String lexeme;
    private final boolean errorOccur;

    private final int lineNumber;

    // Map that convert token to terminal
    private final static Map<String, String> mapTerminal = Collections.unmodifiableMap(new HashMap<String, String>() {
        {
            put("INTEGER", "num");
            put("STRING", "literal");
            put("COMPARISON", "comp");
        }
    });

    public Token(final String tokenName, final String lexeme, final int lineNumber) {
        this.tokenName = tokenName;
        this.lexeme = lexeme;
        this.errorOccur = false;
        this.lineNumber = lineNumber;
    }

    public Token(final String tokenName, final String lexeme, final boolean errorOccur, final int lineNumber) {
        this.tokenName = tokenName;
        this.lexeme = lexeme;
        this.errorOccur = errorOccur;
        this.lineNumber = lineNumber;
    }

    public String getTokenName() {
        return this.tokenName;
    }

    public String getLexeme() {
        return this.lexeme;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public boolean getErrorOccur() {
        return this.errorOccur;
    }

    // Convert to terminal
    public String toTerminal() {

        if (this.tokenName.equals("OP")) {
            // addsub
            if (this.lexeme.equals("+") || this.lexeme.equals("-"))
                return "addsub";
            // multdiv
            if (this.lexeme.equals("*") || this.lexeme.equals("/"))
                return "multdiv";
        }

        // Convert to terminal
        String mapped = mapTerminal.get(this.tokenName);
        if (mapped != null)
            return mapped;

        return this.tokenName.toLowerCase();

    }

}
