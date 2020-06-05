package simulator;

public class Wire {
    private Boolean signal;

    public Wire() {
        this(false);
    }

    public Wire(Boolean signal) {
        this.signal = signal;
    }

    public Boolean getSignal() {
        return signal;
    }

    public void setSignal(Boolean signal) {
        this.signal = signal;
    }
}