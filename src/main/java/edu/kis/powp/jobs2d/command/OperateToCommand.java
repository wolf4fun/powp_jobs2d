package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapters.Job2dAdapter;

public class OperateToCommand implements DriverCommand {
    
    private Job2dDriver driver;
    private int x,y;
    
    OperateToCommand(int x,int y, Job2dDriver driver)
    {
        this.x = x;
        this.y = y;
        this.driver = driver;
    }


    @Override
    public void execute() {
        driver.operateTo(x, y);
    }
}