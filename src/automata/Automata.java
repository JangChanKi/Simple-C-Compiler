package automata;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;

public class Automata {
    private final DFA[] DFAList;
    private final String[] insName = {"IF", "ELSE","WHILE","RETURN","VTYPE","INTEGER","STRING","OP",
            "COMPARISON","ASSIGN","SEMI","LBRACE","RBRACE","LPAREN","RPAREN","COMMA","WHITESPACE","ID"};
    private String lexeme = "";

    public Automata() {
        DFAList = new DFA[insName.length];

        for (int i=0;i< insName.length;i++){
            DFAList[i] = new DFA(insName[i]);
        }
    }

    public void setNextInput(char input) {
        ArrayList<DFA> finalDFAList = new ArrayList<>();

        for (int i=0; i< DFAList.length; i++) {

            // transition 전에 final state에 도달한 dfa를 저장
            if (DFAList[i].isFinal() && !DFAList[i].isRejected())
                finalDFAList.add(DFAList[i]);

            // 모든 dfa에 대해서 현재 input으로 transition 진행
            if (DFAList[i].isRunning())
                DFAList[i].transition(input);
        }

        // 모든 DFA가 reject됨
        if (DFA.rejectCount == DFAList.length) {
            if (finalDFAList.isEmpty()) {
                System.out.println("오류가 발생했습니다.");
                return;
            }

            // 직전 final인 것중 가장 우선순위 높은 것
            System.out.print("<"+finalDFAList.get(0).getName()+"," + lexeme + ">");
            clearAll();
        }
        else {
            lexeme += input;
        }
    }

    private void clearAll() {
        for (int i=0; i< DFAList.length; i++) {
            DFAList[i].clear();
        }
        lexeme = "";
    }
}
