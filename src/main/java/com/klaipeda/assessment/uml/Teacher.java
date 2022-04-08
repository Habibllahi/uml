package com.klaipeda.assessment.uml;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.klaipeda.assessment.uml.Global.elementIsNotYetRegistered;

/**
 * <p>Continuation of Solution to Task 2 of the assessment</p>
 * <p>
 *     This solution further adopt class Teacher as an Entity in a distributed system
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
public class Teacher extends Person{

    /**
     * <p>Total Number of courses registered by a student</p>
     */
    private int numCourses = 0;

    /**
     * <p>Collection of courses registered by student</p>
     */
    private String[] courses = {};

    //constructor

    public Teacher() {
    }

    public Teacher(String name, String address) {
        super(name, address);
        this.numCourses = numCourses;
        this.courses = courses;
        this.courses = new String[5];
    }

    //Business methods : Note in a more realistic real word application,Business codes are moved to business / service layer

    /**
     * Add another course to existing course and return true if successful, return false if the course already exist
     * @param course to add
     * @return
     */
    public boolean addCourse(String course) throws Exception {
        //Add New course and grade
        if(elementIsNotYetRegistered(this.numCourses, this.courses, course)){//Only go ahead to Add Course and Grade if it's not already added
            if(numCourses<5){ //student cant tale more than 30 courses
                courses[numCourses] = course;
                numCourses = numCourses + 1;
                return true;
            }else{
                throw new Exception("Student cant register more than 5 course");
            }
        }else{
            return false;
        }
    }

    /**
     * Remove a course. if the course exist and is succesffully removed, <code>true</code> is returned,
     * if the course does not exist, it wont bother to try to remove it and will return false;
     * @param course course to remove
     * @return boolean
     */
    public boolean removeCourse(String course){
        var courses = Arrays.stream(this.courses).collect(Collectors.toList());
        if(!elementIsNotYetRegistered(this.numCourses, this.courses, course)){
            courses.remove(course);
            this.courses =  courses.toArray(new String[]{});
            return true;
        }else{
            return false;
        }
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
        return courses;
    }

    /**
     * <p>set courses</p>
     * @param courses
     */
    public void setCourses(String[] courses) {
        this.courses = courses;
    }


    //Override methods
    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }

    /**
     * <p>get name of person</p>
     *
     * @return String
     */
    @Override
    public String getName() {
        return super.getName().toUpperCase();
    }
}
