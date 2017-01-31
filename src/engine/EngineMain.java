package engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for testing the creation of objects
 */
public class EngineMain {

    public static void main(String[] args) {
//        testCompanyCreation();
//        testMachineCreation();
//        testContract();
        testProduction();
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
//    public static void testContract(){
//        Company contractor = new Company("MyCompany");
//        Company contractee = new Company("YourCompany");
//
//        Contract contract = new Contract(3, 10.0, 30.0, 50, 25.0, contractor, contractee);
//        System.out.println("New Contract Created: ");
//        System.out.println("Units Needed: " + contract.getUnitsNeeded());
//        System.out.println("Unit Price: " + contract.getPricePerUnit());
//        System.out.println("Total Price: " + contract.getTotalPrice());
//        System.out.println("Credit of Contractor: " + contract.getCreditOfContractor());
//        System.out.println("Time to Fulfill: " + contract.getTimeFrame());
//        System.out.println("Contract ID: " + contract.getContractID());
//        System.out.println("Contractor: " + contract.getVendor());
//        System.out.println("Contractee: " + contract.getContractee());
//    }
    public static void testProduction(){
        List<Machine> machineList = new ArrayList<Machine>();
        Machine newMachine = new Machine(10, 30);
        machineList.add(newMachine);

        Production production = new Production(machineList);
        System.out.println("New Production Order Created");
        System.out.println("Time to Produce: " + production.timeToProduce(3, 10));
        System.out.println("Total Speed of Machines: " + production.getTotalSpeedOfMachines());
    }
}
