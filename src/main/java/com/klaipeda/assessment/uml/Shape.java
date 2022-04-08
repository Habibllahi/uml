package com.klaipeda.assessment.uml;

import javax.persistence.*;


/**
 * <p>Solution to Task 3 of the assessment</p>
 * <p>
 *     The entire program adopts web server approach using H2 in memory database
 *     Thou environment adoption is not required in the question, I just decide to take a step further and apply the
 *     knowledge in to a real world scenario.
 * </p>
 * <p>
 *     It should be noted that its best to make this class Abstract in reality, However the Assessment UML diagram indicates it concrete class
 * </p>
 */
@MappedSuperclass
public abstract class Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected Long id;

    private String color;

    public abstract double getArea();

    public Shape(String color) {
        this.color = color;
    }

    public Shape() {
    }

    //Getters and Setters

    /**
     * <p>get shape color</p>
     * @return String
     */
    public String getColor() {
        return color;
    }

    /**
     * <p>set shape color</p>
     * @param color shape color
     */
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape color= " + this.color;
    }
}
