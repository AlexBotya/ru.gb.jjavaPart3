package ru.geekbrains.java3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

public class TestsForTask2And3 {
  private final ReturnArrayConsistsAllAfterLastFour task2 = new ReturnArrayConsistsAllAfterLastFour();
  private CheckArrayForContentOneAndFour task3 = new CheckArrayForContentOneAndFour();

  @ParameterizedTest
  @MethodSource("task2ArraysProvider")
    public void task2_shouldReturnArrayConsistsAllAfterLastFour(int[] actualArray, int[] expectedArray){

    Assertions.assertArrayEquals(expectedArray,
            task2.getResultArray(actualArray));
  }

  private static Stream<Arguments> task2ArraysProvider(){
    return Stream.of(
            Arguments.of(new int[] {1,4,5,4,7,1,0}, new int[] {7,1,0}),
            Arguments.of(new int[] {4,1}, new int[] {1}),
            Arguments.of(new int[] {1,2,3,4,5,6,7}, new int[] {5,6,7})
    );
  }

  @Test
  public void task2_shouldThrowRuntimeExceptionIfNumberFourIsAbsent(){
    int[] actual = {1,2,3,6,9,0};
    Assertions.assertThrows(RuntimeException.class, () -> task2.getResultArray(actual));

  }
  @ParameterizedTest
  @NullAndEmptySource
  void task2_shouldThrowIllegalArgumentExceptionWhenEmptyArrayPassed(int[] emptyArray) {
    Assertions.assertThrows(IllegalArgumentException.class, () -> task2.getResultArray(emptyArray));
  }

  @ParameterizedTest
  @MethodSource("task3_InputArraysAndResultProvider")

  void t3checkInputArrayForOneAndFourConsist(int[] actualArray, Boolean booleanResult){
    Assertions.assertEquals(booleanResult, task3.doCheck(actualArray));
  }
  private static Stream<Arguments> task3_InputArraysAndResultProvider(){
    return Stream.of(
            Arguments.of(new int[] {1,4,5,4,7,1,0}, true),
            Arguments.of(new int[] {7,6}, false),
            Arguments.of(new int[] {1,2,3,5,6,7}, false),
            Arguments.of(new int[] {4,2,3,5,6,7}, false)
    );
  }
}
