package com.klaipeda.assessment.uml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ShapeTest {

    @Test
    public void classTesting(){
        Shape rectangle = new Rectangle("RED", 15, 24);
        Shape triangle = new Triangle("BLUE", 26, 45);

        assertEquals(360.0, rectangle.getArea());

        assertEquals(585.0, triangle.getArea());
    }


}
