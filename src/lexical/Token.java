package lexical;

/*
인식된 토큰을 테이블 파일로 저장하기 위한 structure
해당 lexeme에서 오류가 발생했을 경우 errorOccur를 활성화시켜서
그 이후의 출력을 중지시킬 수 있습니다.
 */

public class Token {
    private final String tokenName;
    private final String lexeme;
    private final boolean errorOccur;

    public Token(final String tokenName, final String lexeme) {
        this.tokenName = tokenName;
        this.lexeme = lexeme;
        this.errorOccur = false;
    }

    public Token(final String tokenName, final String lexeme, final boolean errorOccur) {
        this.tokenName = tokenName;
        this.lexeme = lexeme;
        this.errorOccur = errorOccur;
    }

    public String getTokenName() {
        return this.tokenName;
    }

    public String getLexeme() {
        return this.lexeme;
    }

    public boolean getErrorOccur() {
        return this.errorOccur;
    }
}
