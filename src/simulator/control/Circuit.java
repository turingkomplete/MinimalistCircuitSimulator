package simulator.control;

import simulator.components.Component;
import simulator.functions.Function;

import java.util.ArrayList;
import java.util.List;

public class Circuit {
    private static List<Component> components = new ArrayList<>();
    private static List<Function> functions = new ArrayList<>();

    public static void addComponent(Component component) {
        components.add(component);
    }

    public static void addFunction(Function function) {
        functions.add(function);
    }

    public static void startAll() {
        for (Component c : components)
            c.startComponent();

        for (Function f: functions)
            f.startFunction();
    }
}
