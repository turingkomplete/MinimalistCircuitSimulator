package simulator.components;

import java.util.ArrayList;
import java.util.Map;

public class Memory extends Component {
    private Boolean[] memory;

    private Memory(String label, Wire... inputs) {
        super(label, inputs);
        for (int i = 0; i < 32; ++i) {
            outputs.add(new Wire(false));
            memory = new Boolean[65536];
        }
    }

    public int address() {
        int temp = 0;
        for (int i = 1; i <= 16; i++) {
            if(inputs.size() > i) {
                if(inputs.get(i).getSignal()) {
                    temp += Math.pow(2, 16 - i);
                }
            }
        }
        return temp;
    }

    private void memoryWrite() {
        //
    }

    private void memoryRead(){
        //
    }

    @Override
    public void runComponent() {
        if (inputs.get(0).getSignal()) {
            memoryWrite();
        } else {
            memoryRead();
        }
    }
}
