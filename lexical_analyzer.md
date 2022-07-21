

# Lexical Analyzer



## 1. The Definition of tokens and their regular expression

### Token 정의와 각 regular expression

1. <VTYPE> : int | INT | char | CHAR
2. <INTEGER> : (( - | $\epsilon$ ) (<nonZeroDigit>)( 0 | <nonZeroDigit> )*) | 0 
3. <STRING> : ( “ ) ( <digit> | <letter> | blank ) ( <digit> | <letter> | blank )* (”)
4. <ID> : <letter>( <letter> | <digit> )*
5. <IF> : if | IF
6. <ELSE> : else | ELSE
7. <WHILE> : while | WHILE
8. <RETURN> : return | RETURN
9. <OP> : + | - | * | /
10. <ASSIGN> : =
11. <COMPARISON> : < | > | == | != | <= | >= 
12. <SEMI> : ;
13. <LBRACE> : {
14. <RBRACE> : }
15. <LPAREN> : )
16. <RPAREN> : )
17. <COMMA>: ,
18. <WHITESPACE> : ( \n | \t | blank)(\n | \t | blank)*

## 2. DFA trasition Graph or Table for Recognizing the Regular Expressions

1번의 정규식을 가지고 DFA와 Table을 만들었습니다.

![dfa table-01.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-01.jpg)

![dfa table-02.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-02.jpg)

![dfa table-03.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-03.jpg)

![dfa table-04.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-04.jpg)

![dfa table-05.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-05.jpg)

![dfa table-06.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-06.jpg)

![dfa table-07.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-07.jpg)

![dfa table-08.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-08.jpg)

![dfa table-10.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-10.jpg)

![dfa table-11.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-11.jpg)

![dfa table-12.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-12.jpg)

![dfa table-13.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-13.jpg)

![dfa table-14.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-14.jpg)

![dfa table-15.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-15.jpg)

![dfa table-16.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-16.jpg)

![dfa table-17.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-17.jpg)

![dfa table-18.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-18.jpg)

![dfa table-19.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-19.jpg)

![dfa table-20.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-20.jpg)

![dfa table-22.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-22.jpg)

![dfa table-23.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-23.jpg)

![dfa table-25.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-25.jpg)

![dfa table-26.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-26.jpg)

![dfa table-27.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-27.jpg)

![dfa table-28 2.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-28_2.jpg)

![dfa table-29.jpg](/Users/kimhyeongki/Downloads/Export-6ce6663f-b385-409b-bc5a-5006ed678958/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/dfa_table-29.jpg)

## 3. How our lexical analyzer works for Recognizing tokens

### Transition Table 구현.

저희는 DFA간 transition(이동)을 나타내기 위한 Transition Table을 json 배열을 이용하여 구현하였습니다.

```json
"VTYPE": {
                "T0": {
                        "i": "T1",
                        "I": "T4",
                        "c": "T7",
                        "C": "T11"
                },
                "T1": {
                        "n": "T2"
                },
                "T2": {
                        "t": "T3"
                },
                "T3": {
                        "final": "true"
                },
                "T4": {
                        "N": "T5"
                },
                "T5": {
                        "T": "T6"
                },
                "T6": {
                        "final": "true"
                },
                "T7": {
                        "h": "T8"
                },
                "T8": {
                        "a": "T9"
                },
                "T9": {
                        "r": "T10"
                },
                "T10": {
                        "final": "true"
                },
                "T11": {
                        "H": "T12"
                },
                "T12": {
                        "A": "T12"
                },
                "T13": {
                        "R": "T13"
                },
                "T14": {
                        "final": "true"
                }
        }
```

이런식으로 모든 TOKEN들의 Transition Table을 위 2번 항목에서 구한 것을 토대로 JSON 형식을 통해 구현하였습니다. JSON 방식으로 구현하게 된 이유는 JSON Object의 value와 key를 이용하여 State와 Transition을 쉽게 구현 할 수 있기 때문에 JSON방식을 택하였습니다.

먼저 위의 STRING Table을 예시로 살펴보면, 먼저 STRING이라는 이름을 가진 Table이고, 각 State에서 어떤 인풋을 받았을 때 다른 State로 이동할 수 있는지에 대한 여부를 나타냈습니다.

그리고 해당 State가 Final State인 경우 Final State에 대한 여부도 나타냈습니다.

### 전체적인 작동방식

![이름 없는 노트북 (/Users/kimhyeongki/Github/Simple-C-Compiler/Compiler Term Project - 1 ed6098d0aa174868a17df98b8dff36cf/이름_없는_노트북_(2)-1.jpg)-1.jpg](Compiler%20Term%20Project%20-%201%20ed6098d0aa174868a17df98b8dff36cf/%E1%84%8B%E1%85%B5%E1%84%85%E1%85%B3%E1%86%B7_%E1%84%8B%E1%85%A5%E1%86%B9%E1%84%82%E1%85%B3%E1%86%AB_%E1%84%82%E1%85%A9%E1%84%90%E1%85%B3%E1%84%87%E1%85%AE%E1%86%A8_(2)-1.jpg)

### Lexical Analyzer class의 구현

```java
public class LexicalAnalyzer {
    private final FileReader fReader;
    private final BufferedWriter fWriter;
    private final Automata automata = new Automata();

    public LexicalAnalyzer (FileReader reader, BufferedWriter bufferedWriter) {
        this.fReader = reader;
        this.fWriter = bufferedWriter;
    }

    public void run() {
        // input file
        try {

            int ch;
            while ((ch = fReader.read()) != -1) {
                Token result = automata.setNextInput((char) ch);

                if (result == null) {
                    // token으로 아직 인식되지 않았을 때
                } else if (result.getErrorOccur()) {
                    // 해당 input에서 오류가 발생한 경우
                    fWriter.write("!----- error occurred at input: "+(char) ch+" ------>\n");
                    fWriter.write("Output is not possible from this line.. ");
                    break;
                } else {
                    // whitespace token은 제외
                    if (!result.getTokenName().equals("WHITESPACE"))
                        fWriter.write("<"+result.getTokenName()+", "+result.getLexeme()+">\n");
                }

            }
            // end character
            automata.setNextInput((char) -1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
```

- `run` : 생성자에서 입력받은 fReader와 fWriter를 이용하여 하나의 파일의 모든 character에 대해 `automata.setNextInput` 을 반복합니다.

  해당 함수가 null을 반환하면 토큰 인식을 다음 차례로 지연시키는 것이고, `errorOccur` 이 true일 경우 해당 input에서 오류가 발생한 것입니다.

  만약 해당 input에 대해 토큰이 인식되었다면 파일에 write를 합니다.

### Automata class의 구현

```java
public class Automata {
    private final String[] insName = {"IF", "ELSE","WHILE","RETURN","VTYPE","OP","INTEGER","STRING",
            "COMPARISON","ASSIGN","SEMI","LBRACE","RBRACE","LPAREN","RPAREN","COMMA","WHITESPACE","ID"};
    private final DFA[] DFAList;

    // - 처리를 위해서 따로 분류
    private final DFA dfaOP;
    private final DFA dfaInt;

    private String lexeme = "";
    private String prevLexeme = "";
    private String prevInput = "";

    public Automata() {
        DFAList = new DFA[insName.length];

        for (int i=0; i< insName.length; i++){
            DFAList[i] = new DFA(insName[i]);
        }

        // - 처리를 위해 사용하는 dfa(op, int)를 쉽게 인식할 수 있도록 저장
        dfaOP = DFAList[5];
        dfaInt = DFAList[6];
    }

    /*
    LexicalAnalyzer에서 입력된 input으로 DFA들을 진행시키는 메소드
    모든 DFA가 reject 되었을 때 그 전 상태에서 final에 도달한 DFA들 중
    가장 우선순위가 높은 것을 token으로 인식한다.
    (만약 final에 도달한 DFA가 없다면, 에러로 인식한다)
    '-' 는 앞의 토큰이 INTEGER, STRING, ID, RPAREN일 때는 INT DFA를 reject 시켜서 OP로 인식시킨다.
     */
    @Nullable
    public Token setNextInput(char input) {
        ArrayList<DFA> finalDFAList = new ArrayList<>();

        // 현재 final state에 도달한 dfa들 목록
        setFinalDFAs(finalDFAList);
        // 현재 input에 대해 transition 진행
        transitionDFA(input);

        // - : OP인지/INTEGER 인지
        if(prevInput.equals("-")) {
            if (prevLexeme.equals("INTEGER") || prevLexeme.equals("STRING") || prevLexeme.equals("ID") || prevLexeme.equals("RPAREN")) {
                dfaInt.reject();
            } else {
                dfaOP.reject();
            }

        }

        // 모든 DFA가 reject됨
        if (DFA.rejectCount == DFAList.length) {
            if (finalDFAList.isEmpty()) {
                System.out.println("오류가 발생했습니다.");
                return new Token("", "", true);
            }

            // 직전 final인 것중 가장 우선순위 높은 것
            Token ret = new Token(finalDFAList.get(0).getName(), lexeme);

            // 이전 결과 저장 (- 처리를 위해서)
            String prev = finalDFAList.get(0).getName();
            if (!prev.equals("WHITESPACE"))
                prevLexeme = prev;

            clearAll(); //Initialize all dfa

            // 현재 input부터 dfa 동작
            finalDFAList.clear();
            setFinalDFAs(finalDFAList);
            lexeme += input;
            transitionDFA(input);

            return ret;
        }
        else {
            lexeme += input;
        }

        // 현재 input을 prev에 저장 (- 처리 위해서)
        prevInput = ""+input;
        return null;
    }

    // transition 전에 final state에 도달한 dfa를 저장
    private void setFinalDFAs(ArrayList<DFA> finalDFAList) {
        for (int i=0; i<DFAList.length; i++) {

            if (DFAList[i].isFinal() && !DFAList[i].isRejected())
                finalDFAList.add(DFAList[i]);
        }
    }

    // 모든 dfa에 대해서 현재 input으로 transition 진행
    private void transitionDFA(char input) {
        for (int i=0; i< DFAList.length; i++) {

            if (DFAList[i].isRunning())
                DFAList[i].transition(input);
        }
    }

    private void clearAll() {
        for (int i=0; i< DFAList.length; i++) {
            DFAList[i].clear();
        }
        lexeme = "";
    }
}
```

- `setFinalDFAs` : 현재 모든 DFA의 상태를 확인하고, final state인 DFA를 저장합니다.

- `transitionDFA` : 현재 input에 대해 모든 DFA에 대해 transition을 진행합니다.

- `setNextInput` : 이전 상태에서 final인 DFA들을 `setFinalDFAs` 로 모두 저장한 후, `transitionDFA` 를 이용해 모든 DFA의 transition을 진행합니다.

  만약 input이 -일 경우에는 이전 Token이 INTEGER, STRING, ID, RPAREN일 경우에는 OP로 인식되기 위해서 IntDFA를 reject 시킵니다. 이전 Token에는 WHITESPACE를 포함하지 않습니다.

  만약 현재 모든 DFA가 reject되었다면 finalDFA에 저장된 (이전 상태에서 final state를 가진 dfa들) DFA 중 가장 높은 우선순위를 갖는 것으로 토큰이 인식됩니다. 이 경우 Token 클래스로 데이터를 만들어서 return합니다. 우선순위는 `insName` 배열이 선언된 순서로 인식할 수 있습니다.

  만약 모든 DFA가 reject되었지만, finalDFA가 비었을 경우 해당 input에 대해 transition을 진행할 수 없는 상태이므로 오류가 발생합니다. 이는 Token 클래스에서 `errorOccur` 를 true로 설정하여 반환합니다.

  만약 현재 input에 대해 reject되지 않은 DFA가 있다면 아직 transition이 진행중이므로, `null` 을 반환하여 output 테이블을 구성하는 것을 지연시킵니다.

### DFA class의 구현

```java
public class DFA {
    public static int rejectCount = 0;
    private boolean isRejected = false;
    private boolean isRunning = true;
    private boolean isFinal = false;
    private String name;
    private String state = "T0";

    DFA(String name) {
        this.name = name;
    }

    public void clear() {
        isRejected = false;
        isRunning = true;
        isFinal = false;
        rejectCount = 0;
        state = "T0";
    }

    /*
    transition 메소드를 통해 새로운 input에 대해서
    다음 state로 이동할 수 있습니다.
    이 과정에서 Transition 클래스의 클래스 메소드가 사용해서 다음 state를 알 수 있으며,
    만약 wrong input으로 reject되었다면 더 이상 state transition을 진행하지 않습니다.
    final에 도달했다면 그 정보를 가지고 있습니다.
     */

    public void transition(char input) {
        String next = Transition.getNextState(this.name, this.state, ""+input);
        // reject
        if (next == null && !this.isRejected) {
            this.isRejected = true;
            this.isRunning = false;
            rejectCount++;
        }
        else {
            // next state
            this.state = next;
            // final state 도달
            if (Transition.isFinalState(this.name, this.state)) {
                this.isFinal = true;
            }

        }
    }

    public String getName() {
        return this.name;
    }

    public boolean isRejected() {
        return isRejected;
    }

    public void reject() {
        if (!this.isRejected) {
            this.isRejected = true;
            this.isRunning = false;
            rejectCount++;
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean isFinal() {
        return isFinal;
    }
}
```

초기에는 T0의 state를 가지고 있습니다.

- `transition` : 다음 input이 입력되었을 때 적절한 state로 이동합니다
- `clear` : 모든 정보를 초기화합니다. state도 T0가 됩니다.

### Error 처리

```c
public Token(final String tokenName, final String lexeme, final boolean errorOccur) {
        this.tokenName = tokenName;
        this.lexeme = lexeme;
        this.errorOccur = errorOccur;
    }
```

- Token에서 `errorOccur` 변수를 만들어 줍니다.

```c
// 모든 DFA가 reject됨
        if (DFA.rejectCount == DFAList.length) {
            if (finalDFAList.isEmpty()) {
                System.out.println("오류가 발생했습니다.");
                return new Token("", "", true);
            }
```

- 만약 DFA에서 input을 받아 DFA를 실행 시킨 뒤 
  (1) 모든 DFA가 Reject 되고 
  (2) finalDFAList에 원소가 아무것도 없으면 
  오류가 발생했다고 console에 print 시킵니다.

```c
else if (result.getErrorOccur()) {
                    // 해당 input에서 오류가 발생한 경우
                    fWriter.write("!----- error occurred at input: "+(char) ch+" ------>\n");
                    fWriter.write("Output is not possible from this line.. ");
                    break;
```

- Lexical Analyzer 안에 있는 run 함수에서의 else if 문입니다. 만약 해당 input에서 위에서 설명한 error(오류)가 발생한 경우 out파일에 뒤의 line부터는 해당 input 때문에 Output을 출력할 수 없다는 메시지를 Write고 run을 종료시킵니다.

## 4. Test

### 사용한 Test.c 파일.

```c
int foo(char num, int d) {
       -0
        while (1<d){
             int a = d+2;
             int b123 = -23 * a / 3 -2;
             int c = (a + b123) - 3 ;
             int if123 = 0;
             char str = "qgkxHIAO1243 ks lJ fa";
             if (a == b123) {
                return a;
             }
             else {
                return if123;
             }
            }
        }
    }
```

해당 Test.c 파일에는 저희가 구현한 all the token patterns 이 들어있는 test 파일입니다.

### Test.out → OUTPUT파일.

```c
<VTYPE, int>
<ID, foo>
<LPAREN, (>
<VTYPE, char>
<ID, num>
<COMMA, ,>
<VTYPE, int>
<ID, d>
<RPAREN, )>
<LBRACE, {>
<OP, ->
<INTEGER, 0>
<WHILE, while>
<LPAREN, (>
<INTEGER, 1>
<COMPARISON, <>
<ID, d>
<RPAREN, )>
<LBRACE, {>
<VTYPE, int>
<ID, a>
<ASSIGN, =>
<ID, d>
<OP, +>
<INTEGER, 2>
<SEMI, ;>
<VTYPE, int>
<ID, b123>
<ASSIGN, =>
<INTEGER, -23>
<OP, *>
<ID, a>
<OP, />
<INTEGER, 3>
<INTEGER, -2>
<SEMI, ;>
<VTYPE, int>
<ID, c>
```

```c
<ASSIGN, =>
<LPAREN, (>
<ID, a>
<OP, +>
<ID, b123>
<RPAREN, )>
<OP, ->
<INTEGER, 3>
<SEMI, ;>
<VTYPE, int>
<ID, if123>
<ASSIGN, =>
<INTEGER, 0>
<SEMI, ;>
<VTYPE, char>
<ID, str>
<ASSIGN, =>
<STRING, "qgkxHIAO1243 ks lJ fa">
<SEMI, ;>
<IF, if>
<LPAREN, (>
<ID, a>
<COMPARISON, ==>
<ID, b123>
<RPAREN, )>
<LBRACE, {>
<RETURN, return>
<ID, a>
<SEMI, ;>
<RBRACE, }>
<ELSE, else>
<LBRACE, {>
<RETURN, return>
<ID, if123>
<SEMI, ;>
<RBRACE, }>
<RBRACE, }>
<RBRACE, }>
```

### 실행방법

```c
java -jar Simple-C-Compiler.jar test1.c
```

를 콘솔에서 실행시킨다.

그리고 두개의 입력파일이 여러개 있을 경우 연달아 써준다.

```java
java -jar Simple-C-Compiler.jar test1.c test2.c test3.c
```

test파일의 경우 jar 파일 기준 ./test-case/ 에 존재해야한다.

