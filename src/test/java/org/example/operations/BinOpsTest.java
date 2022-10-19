package org.example.operations;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

@DisplayName("Тест класса BinOps.")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BinOpsTest {
    private static BinOps binOps;

    @BeforeEach
    void setUp() {
        binOps = new BinOps();
    }

    @AfterEach
    void tearDown() {
        binOps = null;
    }

    @Test
    @Order(2)
    void subNotImplementedAlwaysReturnNull() {
        Assertions.assertNull(binOps.sub("any", "any"));
    }

    @Order(1)
    @NullAndEmptySource
    @MethodSource("getArguments")
    @DisplayName("Тест: checkArgs(a, b) with parameter: ")
    @ParameterizedTest(name = " \"{0}\" throws IllegalArgumentException")
    void checkArgs(String error) {
        Assertions.assertAll("check",
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> binOps.checkArgs(error, "1000"),"check parameter: a"),
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> binOps.checkArgs("1000", error),"check parameter: b")
        );
    }

    private static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.of("1  1"),
                Arguments.of(" 100"),
                Arguments.of("1 00"),
                Arguments.of("10 0"),
                Arguments.of("100 "),
                Arguments.of("1234"),
                Arguments.of("A000"),
                Arguments.of("?001"),
                Arguments.of("!?.,"),
                Arguments.of("    ")
        );
    }
}