package com.klaipeda.assessment.uml;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * <p>Continuation of Solution to Task 3 of the assessment</p>
 * <p>
 *     This solution further adopt class Rectangle as an Entity in a distributed system
 *     The entire program adopts web server approach using H2 in memory database
 *     Thou environment adoption is not required in the question, I just decide to take a step further and apply the
 *     knowledge in to a real world scenario
 * </p>
 */
@Entity
public class Rectangle extends Shape{

    @NotNull
    private int length;

    @NotNull
    private int width;


    public Rectangle() {
    }

    public Rectangle(String color, int length, int width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    /**
     * <p>
     *     Get length of rectangle
     * </p>
     * @return int
     */
    public int getLength() {
        return length;
    }

    /**
     * <p>set length of rectangle</p>
     * @param length rectangle length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * <p>get width of rectangle </p>
     * @return int
     */
    public int getWidth() {
        return width;
    }

    /**
     * <p>set width of rectangle</p>
     * @param width rectangle width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", color=" + getColor() +
                '}';
    }

    @Override
    public double getArea() {
        return length * width;
    }
}
