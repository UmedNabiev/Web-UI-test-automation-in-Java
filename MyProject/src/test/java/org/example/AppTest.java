package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    static Logger logger = LoggerFactory.getLogger(AppTest.class);


    Integer repeated = 0;

    @Test
    @Disabled("??? ????????????")
    @Order(1)
    public void simpleTest()
    {
        logger.info("Information");
        logger.error("Error");
        assertTrue( true );
    }

    @Test
    @DisplayName("??????? ????")
    @Tag("tagTest")
    public void simpleDisableTest()
    {

        assertTrue( true );
    }

    @Test
    @RepeatedTest(10)
    @Tag("tagTest")
    public void repeatedTest()
    {
        //?????????? ?????? ???
        repeated++;
        System.out.println("???????? ??????, ?????: " + repeated);
        assertTrue( true );
    }

    @ParameterizedTest
    @ValueSource(strings = { "word1", "word2", "word3" })
    @Tag("tagTest")
    public void isParameterizedTest(String word){
        System.out.println(word);
    }

    @ParameterizedTest
    @CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
        // @CsvFileSource(resources = "/two-column.csv")
    void testWithCsvSource(String first, int second) {
        System.out.println(first+second);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = { "DAYS", "HOURS" })
    void testWithEnumSourceInclude(TimeUnit timeUnit) {
        assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
    }
}
