package com.mingrisoft.oop;

public class Box {
    private double length;
    private double width;
    private double height;
    
    public double getLength() {
        return length;
    }
    
    public void setLength(double length) {
        if (length <= 0) {
            this.length = 1;
        } else {
            this.length = length;
        }
    }
    
    public double getWidth() {
        return width;
    }
    
    public void setWidth(double width) {
        if (width <= 0) {
            this.width = 1;
        } else {
            this.width = width;
        }
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        if (height <= 0) {
            this.height = 1;
        } else {
            this.height = height;
        }
    }
    
}
