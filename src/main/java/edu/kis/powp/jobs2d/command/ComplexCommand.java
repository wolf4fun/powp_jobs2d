package edu.kis.powp.jobs2d.command;
import java.util.ArrayList;
import java.util.List;

public class ComplexCommand {
    private List<DriverCommand> commandList = new ArrayList<>(); 

    public void executeCommands(){
    
        for (DriverCommand command : commandList) {
            command.execute();
        }
        commandList.clear();
    }

    public void takeCommand(DriverCommand command){
        commandList.add(command);		
    }

}
 

