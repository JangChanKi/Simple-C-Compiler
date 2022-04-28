package automata;

public class DFA {
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
        state = "T0";
    }

    public void transition(String state, boolean isFinal) {
        this.state = state;
        this.isFinal = isFinal;
    }

    public String getState() {
        return this.state;
    }

    public boolean isRejected() {
        return isRejected;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean isFinal() {
        return isFinal;
    }
}
