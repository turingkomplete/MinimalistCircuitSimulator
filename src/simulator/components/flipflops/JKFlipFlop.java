package simulator.components.flipflops;

import simulator.components.Component;
import simulator.functions.Function;
import simulator.Wire;

public class JKFlipFlop extends Component implements FlipFlop {
    private Boolean memory;
    private Boolean edgeFlag;

    public JKFlipFlop(String label, Wire... inputs) {
        super(label, inputs);
        edgeFlag = true;
        initialOutput(2);
        memory = false;
    }

    @Override
    public void setOutput() {
        outputs.get(0).setSignal(memory);
        outputs.get(1).setSignal(!memory);
    }

    @Override
    public void loadMemory() {
        Boolean j = getInput(1).getSignal();
        Boolean k = getInput(2).getSignal();

        if (j && !k)
            memory = true;
        else if (!j && k)
            memory = false;
        else if(j && k)
            memory = !memory;
    }

    @Override
    public void runComponent() {
        if(getInput(0).getSignal() && edgeFlag) {
            setOutput();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            loadMemory();
            edgeFlag = false;
        } else if(!getInput(0).getSignal() && !edgeFlag) {
            edgeFlag = true;
        }
    }
}
