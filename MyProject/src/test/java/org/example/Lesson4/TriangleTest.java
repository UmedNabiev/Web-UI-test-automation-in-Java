package org.example.Lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.example.Lesson4.Triangle.areaTriangle;
import static org.example.Lesson4.Triangle.isTriangle;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    int a = 8;
    int b = 10;
    int c = 8;
    double areaABC = 31.22498999199199;

    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @DisplayName("Test of the possibility of forming a triangle by 3 sides")
    void myIsTriangleABCTest() {
        logger.info("Test of the possibility of forming a triangle by 3 sides");
        assertTrue(!isTriangle(a, b, c), "The sides do not form a triangle");
    }

    @ParameterizedTest
    @DisplayName("Test of the possibility of forming a triangle based on dataset")
    @CsvSource({"5, 6, 9", "3, 4, 4", "1, 1, 1"})
    void myIsTriangleTrueTest(int first, int second, int third) {
        logger.info("Test of the possibility of forming a triangle based on dataset");
        assertTrue(!isTriangle(first, second, third), "A triangle with given sides is possible");
    }

    @ParameterizedTest
    @DisplayName("Test of the impossibility of forming a triangle based on dataset")
    @CsvSource({"2, 2, 10", "-1, 0, 5", "-1, 100, 5"})
    void myIsTriangleFalseTest(int first, int second, int third) {
        logger.info("Test of the impossibility of forming a triangle based on dataset");
        assertFalse(!isTriangle(first, second, third), "The sides do not form a triangle");
    }

    @Test
    @DisplayName("Test for calculating the area of an equilateral triangle on 3 sides")
    public void equalArealTriangleABCTest() {
        logger.info("Test for calculating the area of an equilateral triangle on 3 sides");
        assertEquals(areaABC, areaTriangle(a, b, c), "Area calculation error");
    }

    @ParameterizedTest
    @DisplayName("Calculation test")
    @CsvSource({"1, 1, 1, 0.4330127018922193", "3, 4, 5, 6", "5, 5, 5, 10.825317547305483"})
    public void equalArealTriangleTest(int first, int second, int third, double area) {
        logger.info("Calculation test");
        assertEquals(area, areaTriangle(first, second, third), "Area calculation error");
    }

    @ParameterizedTest
    @DisplayName("Exception test")
    @CsvSource({"-1, 1, 1", "3, 0, 5", "1, 5, -5"})
    void testException(int first, int second, int third) {
        logger.info("Exception test");
        Assertions.assertThrows(Triangle.checkNumbersException.class, () -> Triangle.checkNumbers(first, second, third), "No exception");
    }

}
