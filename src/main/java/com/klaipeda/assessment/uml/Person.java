package com.klaipeda.assessment.uml;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * <p>Solution to Task 2 of the assessment</p>
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
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected Long id;

    /**
     * <p>name of person</p>
     * <p> can not be null or empty</p>
     */
    @NotNull
    @NotEmpty
    private String name;

    //constructor


    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Person() {
    }

    /**
     * <p>
     *     Address of person
     * </p>
     * <p>Can not be null or empty</p>
     */
    @NotNull
    @NotEmpty
    private String address;


    /**
     * <p>get name of person</p>
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Set name of person</p>
     * @param name name of person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>get address of person</p>
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * <p>Address of this person</p>
     * @param address person's address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * <p>
     *     Get ID, this variable is not stated in the assessment UML diagram, however its required to adopt this class
     *     as a Table in the ORM in-memory database (H2).
     * </p>
     * @return Long
     */
    public Long getId() {
        return id;
    }

    /**
     * <p>
     *     set ID field
     * </p>
     * @param id  ID of the Author instant as a row in the database table Author
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name+"("+this.address+")";
    }
}
