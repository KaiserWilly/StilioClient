package engine;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by The Man on 1/28/2017.
 */
public class Machine implements Serializable{
    Integer quality;
    Integer durability;
    Integer totalMachineStrength;
    Integer chanceToReduceMachineStrength;

    public void Machine(Integer qualityScore, Integer durabilityScore){
        quality = qualityScore;
        durability = durabilityScore;
        SetTotalMachineStrength();
        SetChanceToReduceMachineStrength();
    }

    public Integer SetTotalMachineStrength(){
        Random strengthAdjustment = new Random();
        if (strengthAdjustment.nextInt(100 + 1) > 50) {
            totalMachineStrength = durability + strengthAdjustment.nextInt(10 + 1);
        }
        else{
            totalMachineStrength = durability - strengthAdjustment.nextInt(10 + 1);
        }
        return totalMachineStrength;
    }
    public Integer SetChanceToReduceMachineStrength(){
        Random qualityAdjustment = new Random();
        if (qualityAdjustment.nextInt(100 + 1) > 50){
            chanceToReduceMachineStrength = quality - qualityAdjustment.nextInt(10 + 1);
            if (chanceToReduceMachineStrength <= 0){
                chanceToReduceMachineStrength = 1;
            }
        }
        else{
            chanceToReduceMachineStrength = quality + qualityAdjustment.nextInt(10 + 1);
        }
        return chanceToReduceMachineStrength;
    }
}
