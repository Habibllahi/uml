package com.klaipeda.assessment.uml;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

import static com.klaipeda.assessment.uml.Global.elementIsNotYetRegistered;

/**
 * <p>Continuation of Solution to Task 2 of the assessment</p>
 * <p>
 *     This solution further adopt class Student as an Entity in a distributed system
 *     The entire program adopts web server approach using H2 in memory database
 *     Thou environment adoption is not required in the question, I just decide to take a step further and apply the
 *     knowledge in to a real world scenario.
 * </p>
 * <p>
 *     It should be noted that its best to make <code>courses</code> an entity/class of its own with relationship with Student,
 *     However its implemented here as the UML diagram stated in the assessment
 * </p>
 *
 */
@Entity
public class Student extends Person{

    /**
     * <p>Total Number of courses registered by a student</p>
     */
    @Column(name = "number_of_courses")
    private int numCourses = 0;

    /**
     * <p>Collection of courses registered by student</p>
     *
     */
    private String[] courses = {};

    /**
     * <p>collection of grades for the course</p>
     */
    private int[] grade = {};

    //constructor
    public Student(String name, String address) {
        super(name, address);
        this.courses = new String[30]; //considering the course can't be more than 30
        this.grade = new int[30]; //considering the course can't be more than 30
    }

   public Student(){

   }

    //Business methods : Note in a more realistic real word application,Business codes are moved to business / service layer

    /**
     * <p>Add course and Grade</p>
     * <p>This method can throw <code>Exception</code> at runtime if student tries to register more than 30 course or course already exist</p>
     * @param course course name
     * @param grade grade value
     */
    public void addCourseGrade(@NotEmpty @NotNull String course, @NotEmpty @NotNull int grade) throws Exception {
        //Add New course and grade
        if(elementIsNotYetRegistered(this.numCourses, this.courses, course)){//Only go ahead to Add Course and Grade if it's not already added
            if(numCourses<30){ //student cant tale more than 30 courses
                courses[numCourses] = course;
                this.grade[numCourses] = grade;
                numCourses = numCourses + 1;
            }else{
                throw new Exception("Student cant register more than 30 course");
            }
        }else{
            throw new Exception("The course you are trying to add already exist");
        }
    }

    /**
     * <p>
     *     Get average grade of this student
     * </p>
     * <p>
     *     This method can throw <code>NoSuchElementException</code> at runtime
     * </p>
     * @return double
     */
    public double getAverageGrade(){
        return Arrays.stream(this.grade).average().getAsDouble(); //this can throw NoSuchElementException if grade is empty
    }

    /**
     * <p>
     *     Print grades of this student
     * </p>
     */
    public void printGrades(){
        //I will print with some fancy decoration
        System.out.println("***********************************************************");
        for(var course : this.courses){
            for(var grade : this.grade){
                System.out.print("***** "+ course + ": ");
                System.out.print(grade); //print grade
                System.out.println(" *****");
            }
        }
        System.out.println("***********************************************************");
    }


    //getters and setters

    /**
     * <p>get total number of courses registered by student</p>
     * @return int
     */
    public int getNumCourses() {
        return this.courses.length;
    }

    /**
     * <p>set number of courses</p>
     * @param numCourses
     */
    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }

    /**
     * <p>get courses registered by this student</p>
     * @return String[]
     */
    public String[] getCourses() {
        return this.courses;
    }

    /**
     * <p>set courses</p>
     * @param courses
     */
    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    /**
     * <p>get grades</p>
     * @return int[]
     */
    public int[] getGrade() {
        return grade;
    }

    /**
     * <p>set grades</p>
     * @param grade
     */
    public void setGrade(int[] grade) {
        this.grade = grade;
    }

    //Override methods
    @Override
    public String toString() {
        return "Student: " + super.toString();
    }

    /**
     * <p>get name of person</p>
     *
     * @return String
     */
    @Override
    public String getName() {
        return super.getName().toLowerCase();
    }
}
