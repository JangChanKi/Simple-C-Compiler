package automata;


import java.util.List;

public class Automata {
    private final DFA[] DFAList;
    private final String[] insName = {"IF", "ELSE","WHILE","RETURN","VTYPE","INTEGER","STRING","OP",
            "COMPARISON","ASSIGN","SEMI","LBRACE","RBRACE","LPAREN","RPAREN","COMMA","WHITESPACE","ID"};

    public Automata() {
        DFAList = new DFA[insName.length];

        for (int i=0;i< insName.length;i++){
            DFAList[i] = new DFA(insName[i]);
        }
    }

    public void setNextInput(char input) {
        for (int i=0; i< DFAList.length; i++) {
            stateCheck(DFAList[i], input);
        }
    }

    private void stateCheck(DFA dfa, char input) {
        // dfa가 running일 때 다음 input 적용
        if (dfa.isRunning()) {
            dfa.transition(input);
        }
    }



}
