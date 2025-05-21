package edu.niu.cs.z1904531.portfolio3;

public class Burger {
    //constants
    static final int BEEF = 90,
            TURKEY = 170,
            VEGGIE = 150,
            CHEDDAR = 113,
            MOZZARELLA = 78,
            BACON = 86;

    private int pattyCalories, cheeseCalories, baconCalories, sauceCalories;

    //constructor
    public Burger() {
        pattyCalories = BEEF;
        cheeseCalories = 0;
        baconCalories = 0;
        sauceCalories = 0;
    }

    //setterS
    public void setPattyCalories(int newPattyCalories) {
        pattyCalories = newPattyCalories;
    }

    public void setCheeseCalories(int newCheeseCalories) {
        cheeseCalories = newCheeseCalories;
    }

    public void setBaconCalories(boolean hasBacon) {
        if (hasBacon){
            baconCalories = BACON;
        }
        else{
            baconCalories = 0;
        }
    }

    public void setSauceCalories(int newSauceCalories) {
        sauceCalories = newSauceCalories;
    }

    //method to calculate total number of calories
    public int calcTotalCalories(){
        return pattyCalories + cheeseCalories + baconCalories + sauceCalories;
    }

}// end Burger
