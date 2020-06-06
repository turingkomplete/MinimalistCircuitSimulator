package simulator.components;

import simulator.Wire;
import simulator.functions.Function;

public class Clock extends Component {
    private boolean state;

    public Clock(String label, long delay, Wire... inputs) {
        super(label, delay, inputs);
        state = false;
        initialOutput(1);
    }

    private void toggle() {
        state = !state;
    }

    @Override
    public void runComponent() {
        toggle();
        getOutput(0).setSignal(state);
    }
}
