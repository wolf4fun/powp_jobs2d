package edu.kis.powp.jobs2d.command;
import edu.kis.powp.jobs2d.drivers.adapters.Job2dAdapter;

public class CommandDemo {
    public static void main(String[] args) {
        Job2dAdapter adapter = new Job2dAdapter();

        DriverCommand oCommand = new OperateToCommand(10, 10, adapter);
        DriverCommand sCommand = new SetPositionCommand(10, 10, adapter);

        ComplexCommand commandComplex = new ComplexCommand();
        commandComplex.takeCommand(oCommand);
        commandComplex.takeCommand(sCommand);

        commandComplex.executeCommands();
    }
}