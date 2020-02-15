package com.mingrisoft.oop;


public class Test {
    public static void main(String[] args) {
        System.out.println("自定義普通的汽車：");
        Car car = new Car();
        car.setName("Adui");
        car.setSpeed(60);
        System.out.println(car);
        System.out.println("自定義GPS汽車：");
        GPSCar gpsCar = new GPSCar();
        gpsCar.setName("Audi");
        gpsCar.setSpeed(60);
        System.out.println(gpsCar);
    }
}
