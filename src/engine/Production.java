package engine;

import java.io.Serializable;
import java.util.List;

/**
 * Used to simulated the production floor of the company, to create whatever the company is currently creating whether it be coal or machines
 */
public class Production implements Serializable{
    private List<Machine> machinesOnFloor;
    private Integer totalSpeedOfMachines;

    public Production(List<Machine> machinesOnFloor){
        this.machinesOnFloor = machinesOnFloor;
    }

    public void setMachinesOnFloor(List<Machine> machinesOnFloor){
        this.machinesOnFloor = machinesOnFloor;
    }
    public List<Machine> getMachinesOnFloor(){
        return machinesOnFloor;
    }

    public Integer timeToProduce(Integer numberOfItems, Integer timePerItem){
        Integer time = numberOfItems * timePerItem;
        for (int i = 0; i < machinesOnFloor.size();i++){
            time = time / machinesOnFloor.get(i).getSpeedOfMachine();
        }
        return time;
    }
}
