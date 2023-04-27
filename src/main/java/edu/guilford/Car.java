package edu.guilford;

import java.util.Random;

public class Car {

    Random rand = new Random();

    // attributes

    private String make;
    private String model;
    private int year;
    private int price;
    private int mileage;

    // constructors

    public Car() {
        make = "Make";
        model = "Model";
        year = rand.nextInt(24) + 2000;
        price = rand.nextInt(10000) + 10000;
        mileage = rand.nextInt(200000) + 10000;
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        year = rand.nextInt(24) + 2000;
        price = rand.nextInt(10000) + 10000;
        mileage = rand.nextInt(200000) + 10000;
    }

    public Car(String make, String model, int year, int price, int mileage) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
    }

    // methods

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Car{" + "make=" + make + ", model=" + model + ", year=" + year + ", price=" + price + ", mileage="
                + mileage + '}';
    }

    // Helper method

    public void goodBrand() {
        if (make.equals("Honda") || make.equals("Toyota") || make.equals("Ford") || make.equals("Chevrolet")) {
            System.out.println("This is a good brand.");
        } else {
            System.out.println("This is not a good brand.");
        }
    }

    // Analyze the car on a scale of based on the attributes:

    public int analyze() {
        int score = 0;
        if (year > 2010) {
            score += 10;
        } else if (year > 2000) {
            score += 8;
        } else if (year > 1990) {
            score += 6;
        } else if (year > 1980) {
            score += 4;
        } else if (year > 1970) {
            score += 2;
        } else {
            score += 1;
        }
        if (price < 10000) {
            score += 10;
        } else if (price < 20000) {
            score += 8;
        } else if (price < 30000) {
            score += 6;
        } else if (price < 40000) {
            score += 4;
        } else if (price < 50000) {
            score += 2;
        } else {
            score += 1;
        }
        if (mileage < 10000) {
            score += 10;
        } else if (mileage < 20000) {
            score += 8;
        } else if (mileage < 30000) {
            score += 6;
        } else if (mileage < 40000) {
            score += 4;
        } else if (mileage < 50000) {
            score += 2;
        } else {
            score += 1;
        }
        return score;
    }

}
