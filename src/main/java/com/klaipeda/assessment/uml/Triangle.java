package com.klaipeda.assessment.uml;

import javax.persistence.Entity;

@Entity
public class Triangle extends Shape{
    private int base;

    private int height;


    public Triangle() {
    }

    public Triangle(String color, int base, int height) {
        super(color);
        this.base = base;
        this.height = height;
    }


    /**
     * <p>get base of triangle</p>
     * @return int
     */
    public int getBase() {
        return base;
    }

    /**
     * <p>set triangle base</p>
     * @param base
     */
    public void setBase(int base) {
        this.base = base;
    }

    /**
     * <p>get height of triangle</p>
     * @return int
     */
    public int getHeight() {
        return height;
    }

    /**
     * <p>set triangle height</p>
     * @param height height of triangle
     */
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", height=" + height +
                ", color=" + getColor() +
                '}';
    }

    @Override
    public double getArea() {
        return  (base * height)/2;
    }
}
