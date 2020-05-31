package simulator.components;

public class Or extends Component {
    public Or(String label, Wire ... inputs) {
        super(label, inputs);
        outputs.add(new Wire(false));
    }

    @Override
    public void runComponent() {
        Wire result = new Wire(false);
        for(Wire w : inputs) {
            result.setSignal(result.getSignal() || w.getSignal());
        }

        outputs.get(0).setSignal(result.getSignal());
    }
}