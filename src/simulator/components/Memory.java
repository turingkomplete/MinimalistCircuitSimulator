package simulator.components;

public class Memory extends Component {
    private Boolean[] memory;

    private Memory(String label, Wire... inputs) {
        super(label, inputs);
        memory = new Boolean[65536];
        for (int i = 0; i < 32; ++i) {
            outputs.add(new Wire(false));
        }
    }

    public int address() {
        int temp = 0;
        for (int i = 1; i <= 16; ++i) {
            if(inputs.size() > i) {
                if(inputs.get(i).getSignal()) {
                    temp += Math.pow(2, 16 - i);
                }
            }
        }
        return temp;
    }

    private void memoryWrite() {
        for(int i = 17; i <= 48; ++i) {
            memory[address() + i - 17] = inputs.get(i).getSignal();
        }
    }

    private void memoryRead(){
        for (int i = 0; i < 32; ++i) {
            getOutput(i).setSignal(memory[address() + i]);
        }
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
