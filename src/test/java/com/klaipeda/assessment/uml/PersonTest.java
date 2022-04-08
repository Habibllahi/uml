package com.klaipeda.assessment.uml;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonTest {
    Student student = null;
    Teacher teacher = null;
    @BeforeEach
    public void setup(){
        teacher = new Teacher("Williams Shark", "Silicon Valley");
        student = new Student("Hamzat Habibllahi", "Lake val, 24 Otorito street");
    }
    @Test
    public void addCourseGradeByStudent() throws Exception {
        student.addCourseGrade("Introduction to computing", 90);
        student.addCourseGrade("Introduction to Java", 98);
        student.addCourseGrade("Introduction to Python", 98);
        assertEquals(student.getCourses()[0], "Introduction to computing");
        assertEquals(student.getCourses()[1], "Introduction to Java");
        assertEquals(student.getCourses()[2], "Introduction to Python");
    }

    @Test
    public void addCourseGradeThatIsAlreadyRegisteredByStudent(){
        try{
            student.addCourseGrade("Introduction to computing", 90);
            student.addCourseGrade("Introduction to Java", 98);
            student.addCourseGrade("Introduction to Python", 98);
            student.addCourseGrade("Introduction to Java", 90);
        }catch (Exception exception){
            assertEquals("The course you are trying to add already exist", exception.getMessage());
        }

    }

    @Test
    public void addCourseByTeacher() throws Exception {
        teacher.addCourse("Introduction to computing");
        teacher.addCourse("Introduction to Java");
        teacher.addCourse("Introduction to Python");
        assertEquals(teacher.getCourses()[0], "Introduction to computing");
        assertEquals(teacher.getCourses()[1], "Introduction to Java");
        assertEquals(teacher.getCourses()[2], "Introduction to Python");
    }

    @Test
    public void addCourseThatIsAlreadyRegisteredByTeacher() throws Exception {
        teacher.addCourse("Introduction to computing");
        teacher.addCourse("Introduction to Java");
        teacher.addCourse("Introduction to Python");

        assertEquals(false, teacher.addCourse("Introduction to Java"));
    }

    @Test
    public void removeAlreadyAddedCourseByTeacher() throws Exception {
        teacher.addCourse("Introduction to computing");
        teacher.addCourse("Introduction to Java");
        teacher.addCourse("Introduction to Python");

        assertEquals(true,teacher.removeCourse("Introduction to Java"));
    }

    @Test
    public void removeNonAddedCourseByTeacher() throws Exception {
        teacher.addCourse("Introduction to computing");
        teacher.addCourse("Introduction to Java");
        teacher.addCourse("Introduction to Python");

        assertEquals(false,teacher.removeCourse("Introduction to Dart"));
    }

    @Test
    public void demonstrationOfInheritanceCase(){
        //What is expected is that, teacher and student toString method, executes the Person toString method
        var person = new Person("Otedolu", "Bolarewal Street, Indiana");
        System.out.println("***********************************************************");

        System.out.print("***** ");
        System.out.print(person); //print person
        System.out.println(" *****");
        System.out.print("***** ");
        System.out.print(teacher); //print teacher
        System.out.println(" *****");
        System.out.print("***** ");
        System.out.print(student); //print student
        System.out.println(" *****");
        System.out.println("***********************************************************");
    }


    @Test
    public void demonstrationOfPolymorphismCase(){
        Person person = new Person("Otedolu", "Bolarewal Street, Indiana");
        Person teacher = new Teacher("Olaja", "Jakuda Street, Indiana");
        Person student = new Student("Mophem", "Banke Street, Indiana");

        System.out.println("***********************************************************");

        System.out.print("***** ");
        System.out.print(person.getName()); //print person
        System.out.println(" *****");
        System.out.print("***** ");
        System.out.print(teacher.getName()); //print teacher
        System.out.println(" *****");
        System.out.print("***** ");
        System.out.print(student.getName()); //print student
        System.out.println(" *****");
        System.out.println("***********************************************************");
    }
}
