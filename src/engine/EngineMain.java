package engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by The Man on 1/28/2017.
 */
public class EngineMain {

    public static void main(String[] args) {
        List<Machine> machineList = new ArrayList<Machine>();
        Machine newMachine = new Machine(10, 30);
        machineList.add(newMachine);
        Company owner = new Company("MyCompany","Mining",10000.0,machineList);
        System.out.println("Company Created" + owner.getCompanyName());
    }
}
