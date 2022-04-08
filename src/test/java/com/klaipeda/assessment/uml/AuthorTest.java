package com.klaipeda.assessment.uml;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorTest {

    @Test
    public void classTesting(){
        var author1 = new Author("Habib Kaziz","habibllahi3@gmail.com",'m');
        var author2 = new Author("Adeleke Maya", "adeleke@gmail.com", 'f');

        //I will print with some fancy decoration
        System.out.println("***********************************************************");

        System.out.print("***** ");
        System.out.print(author1); //print Author 1
        System.out.println(" *****");
        System.out.print("***** ");
        System.out.print(author2); //print Author 2
        System.out.println(" *****");

        System.out.println("***********************************************************");
    }
}
