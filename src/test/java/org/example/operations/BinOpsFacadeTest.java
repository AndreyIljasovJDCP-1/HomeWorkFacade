package org.example.operations;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
@DisplayName("Тест класса BinOpsFacade.")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BinOpsFacadeTest {
    private static BinOpsFacade facade;

    @BeforeAll
    static void setUp() {
        facade = new BinOpsFacade();
    }

    @AfterAll
    static void tearDown() {
        facade = null;
    }

    @Order(1)
    @DisplayName("Тест: sum(a, b)")
    @MethodSource("getArgumentsSum")
    @ParameterizedTest(name = "{0} + {1} = {2} ")
    void sum(String a,String b,String expected) {
        Assertions.assertEquals(expected,facade.sum(a, b));
    }

    private static Stream<Arguments> getArgumentsSum() {
        return Stream.of(
                Arguments.of("10", "10","0100"),
                Arguments.of("1111", "1","00010000"),
                Arguments.of("1", "1","0010")
        );
    }

    @Order(2)
    @DisplayName("Тест: mult(a, b)")
    @MethodSource("getArgumentsMult")
    @ParameterizedTest(name = "{0} * {1} = {2} ")
    void mult(String a,String b,String expected) {
        Assertions.assertEquals(expected,facade.mult(a, b));
    }

    private static Stream<Arguments> getArgumentsMult() {
        return Stream.of(
                Arguments.of("10", "10","0100"),
                Arguments.of("1111", "1","1111"),
                Arguments.of("1000", "0010","00010000")
        );
    }
}