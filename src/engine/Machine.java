package engine;

import java.io.Serializable;
import java.util.Random;

/**
 * Used to create new production machines to keep all values associated with the machine together in the machine object
 */
public class Machine implements Serializable{
    private Integer quality;
    private Integer durability;
    private Integer totalMachineStrength;
    private Double chanceToReduceMachineStrength;
    private Integer speedOfMachine;

    public Machine(Integer qualityScore, Integer durabilityScore){
        quality = qualityScore;
        durability = durabilityScore;
        SetTotalMachineStrength();
        SetChanceToReduceMachineStrength();
        SetSpeedOfMachine();
    }

    public Integer getQuality(){
        return quality;
    }
    public Integer getDurability(){
        return durability;
    }
    public Integer getTotalMachineStrength(){
        return totalMachineStrength;
    }
    public Double getChanceToReduceMachineStrength(){
        return chanceToReduceMachineStrength;
    }
    public Integer getSpeedOfMachine(){
        return speedOfMachine;
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
    public Double SetChanceToReduceMachineStrength(){
        Random qualityAdjustment = new Random();
        if (qualityAdjustment.nextInt(100 + 1) > 50){
            chanceToReduceMachineStrength = 1/quality - ((double)(int)(qualityAdjustment.nextDouble() * 100))/100;
            if (chanceToReduceMachineStrength <= 0){
                chanceToReduceMachineStrength = .01;
            }
        }
        else{
            chanceToReduceMachineStrength = 1/quality + ((double)(int)(qualityAdjustment.nextDouble() * 100))/100;
        }
        return chanceToReduceMachineStrength;
    }
    public Integer SetSpeedOfMachine(){
        Random speedAdjustment = new Random();
        if (speedAdjustment.nextInt(100 + 1 + quality) >= 100 ){
            speedOfMachine = quality + speedAdjustment.nextInt(10 + 1);
        }
        else {
            speedOfMachine = quality - speedAdjustment.nextInt(10 + 1);
            if (speedOfMachine <= 0){
                speedOfMachine = 1;
            }
        }
        return speedOfMachine;
    }
}
