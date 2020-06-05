package simulator.components.flipflops;

import simulator.components.Component;
import simulator.functions.Function;
import simulator.Wire;

public class DFlipFlop extends Component implements FlipFlop {
    private Boolean memory;
    private Boolean edgeFlag;

    public DFlipFlop(String label, Wire... inputs) {
        super(label, inputs);
        edgeFlag = true;
        memory = false;
        initialOutput(1);
    }

    public DFlipFlop(Function function, String label, Wire... inputs) {
        super(function, label, inputs);
        edgeFlag = true;
        memory = false;
        outputs.add(new Wire(false));
    }

    @Override
    public void setOutput() {
        outputs.get(0).setSignal(memory);
    }

    @Override
    public void loadMemory() {
        if(inputs.size() >= 2)
            memory = inputs.get(1).getSignal();
    }

    @Override
    public void runComponent() {
        if(inputs.get(0).getSignal() && edgeFlag) {
            setOutput();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            loadMemory();
            edgeFlag = false;
        } else if(!inputs.get(0).getSignal() && !edgeFlag) {
            edgeFlag = true;
        }
    }
}
