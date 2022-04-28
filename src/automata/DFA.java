package automata;

public class DFA {
    // finalcount, rekjectcount, finalflag 논 필요
    private static int finalCount = 0;
    public static int rejectCount = 0;
    private boolean isRejected = false;
    private boolean isRunning = true;
    private boolean isFinal = false;
    private boolean finalFlag = true;
    private String name;
    private String state = "T0";

    DFA(String name) {
        this.name = name;
    }

    public void clear() {
        isRejected = false;
        isRunning = true;
        isFinal = false;
        finalFlag = true;
        finalCount = 0;
        rejectCount = 0;
        state = "T0";
    }

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
            if (Transition.isFinalState(this.name, this.state) && finalFlag) {
                this.isFinal = true;
                finalCount++;
                finalFlag = false;
            }

        }
    }

    public String getName() {
        return this.name;
    }

    public String getState() {
        return this.state;
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
