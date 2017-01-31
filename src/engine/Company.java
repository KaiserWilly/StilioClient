package engine;

import java.io.Serializable;
import java.util.List;

/**
 * Created in order to set the parameters of a Company object, and methods to set the values that can be found therein
 */
public class Company implements Serializable{

    private String companyName = "";
    private String industry = "";
    private Double moneyOnHand = 0.0;
    private Double companyValue = 0.0;
    private Integer creditScore = 0;
    private List<Machine> machines;
    private List Inventory;

    public Company(String name, String indName, Double money, List<Machine> productionMachines) { //Used for company creation, initizes the starting values of the company
        companyName = name;
        industry = indName;
        moneyOnHand = money;
        companyValue = money;
        creditScore = 50;
        machines = productionMachines;
    }

    public Company(String name){
        companyName = name;
    }

    public Company(String name, String indName, Integer credit) {
        companyName = name;
        industry = indName;
        creditScore = credit;
    }

    public Company(Double money) {
        moneyOnHand = money;
    }

    public Company(List inventory) {
        machines = inventory;
    }

    public void setCompanyName(String name) {
        companyName = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setIndustry(String industryName) {
        industry = industryName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setMoneyOnHand(Double money) {
        moneyOnHand = money;
    }

    public Double getMoneyOnHand() {
        return moneyOnHand;
    }

    public void setCompanyValue(Double value) {
        companyValue = value;
    }

    public Double getCompanyValue() {
        return companyValue;
    }

    public void setCreditScore(Integer credit) {
        creditScore = credit;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setMachines(List<Machine> machines){
        this.machines = machines;
    }

    public List<Machine> getMachines(){
        return this.machines;
    }

    public void changeMoney(Double change) { //If money is spent or earned then this is what changes it
        if (change > 0) {
            moneyOnHand = moneyOnHand + change;
        } else {
            moneyOnHand = moneyOnHand - change;
        }
    }

    public void companyValueChange(Double change) { //If company value is gained or lost this is what changes it
        if (change > 0) {
            companyValue = companyValue + change;
        } else {
            companyValue = companyValue - change;
        }
    }

    public void creditChange(Integer change) { //If credit score goes down or up then this is what changes it
        if (change > 0) {
            creditScore = creditScore + change;
        } else {
            creditScore = creditScore - change;
        }
    }
}