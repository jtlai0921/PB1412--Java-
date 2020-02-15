package com.mingrisoft.oop;

import java.awt.Point;

public class GPSCar extends Car implements GPS {
    
    @Override
    public Point getLocation() {
        Point point = new Point();
        point.setLocation(super.getSpeed(), super.getSpeed());
        return point;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", ®y¼Ð¡G(" + getLocation().x + ", " + getLocation().y + ")");
        return sb.toString();
    }
}
