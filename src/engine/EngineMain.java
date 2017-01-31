package engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by The Man on 1/28/2017.
 */
public class EngineMain {

    public static void main(String[] args) {
//        testCompanyCreation();
        testMachineCreation();
    }
    public static void testCompanyCreation(){
        List<Machine> machineList = new ArrayList<Machine>();
        Machine newMachine = new Machine(10, 30);
        machineList.add(newMachine);
        Company owner = new Company("MyCompany","Mining",10000.0,machineList);
        System.out.println("Company Created: " + owner.getCompanyName());
        System.out.println("Industry: " + owner.getIndustry());
        System.out.println("Money on Hand: " + owner.getMoneyOnHand());
        System.out.println("Inventory: " + owner.getMachines().size() + " machine(s)");
    }
    public static void testMachineCreation(){
        Machine machine = new Machine(10, 30);
        System.out.println("New Machine Created");
        System.out.println("Quality: " + machine.getQuality());
        System.out.println("Durability: " + machine.getDurability());
        System.out.println("Machine Strength: " + machine.getTotalMachineStrength());
        System.out.println("Chance to Reduce Machine Strength: " + machine.getChanceToReduceMachineStrength());
        System.out.println("Production Speed: " + machine.getSpeedOfMachine());
    }
    public static void testProduction(){

    }
}
