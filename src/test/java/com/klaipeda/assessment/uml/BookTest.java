package com.klaipeda.assessment.uml;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {

    @Test
    public void classTesting(){
        var author1 = new Author("Habib Kaziz","habibllahi3@gmail.com",'m');
        var author2 = new Author("Adeleke Maya", "adeleke@gmail.com", 'f');

        var book1 = new Book("Know Your Friend", author1, 100.23, 5);
        var book2 = new Book("Know Your Friend", author2, 200.23, 5);


        //I will print with some fancy decoration
        System.out.println("***********************************************************");

        System.out.print("***** ");
        System.out.print(book1); //print book 1
        System.out.println(" *****");
        System.out.print("***** ");
        System.out.print(book2); //print book 2
        System.out.println(" *****");

        System.out.println("***********************************************************");
    }
}
