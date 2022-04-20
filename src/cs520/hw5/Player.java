package cs520.hw5;

import java.util.Random;

public class Player {
    private int number;
    private String name;
    private String position;
    private String year;

    public Player() { 
        super();
    }

    public Player(String name) {
        this.name = name;
    }

    public String toString() {   
        return "#" + this.number + ": " + this.name + " (" + this.position + ", " + this.year + ")";
    }

    public Double computeScoringAverage(){
        Random r = new Random();
        double randomValue = 10.0*r.nextDouble();
        return randomValue;
    }


    public int getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public String getYear() {
        return year;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setYear(String year) {
        this.year = year;
    }
}

