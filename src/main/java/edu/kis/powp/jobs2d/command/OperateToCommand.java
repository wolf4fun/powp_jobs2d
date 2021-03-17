package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.drivers.adapters.Job2dAdapter;

public class OperateToCommand implements DriverCommand {
    
    private Job2dAdapter adapter;
    private int x,y;
    
    OperateToCommand(int x,int y, Job2dAdapter adapter)
    {
        this.x = x;
        this.y = y;
        this.adapter = adapter;
    }


    @Override
    public void execute() {
        adapter.operateTo(x, y);
    }
}