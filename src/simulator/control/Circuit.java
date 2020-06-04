package simulator.control;

import simulator.components.Component;
import simulator.components.Function;

import java.util.ArrayList;

public class Circuit {
    public static ArrayList<Component> components = new ArrayList<>();
    public static ArrayList<Function> functions = new ArrayList<>();

    public static void addComponent(Component component) {
        components.add(component);
    }

    public static void addFunction(Function function) {
        functions.add(function);
    }

    public static void startAll() {
        for (Function f: functions)
            f.initialFunction();

        for (Component c : components)
            c.startComponent();

        for (Function f: functions)
            f.startFunction();
    }
}
