package ru.geekbrains.java3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task2And3Tests {
  private final ReturnArrayConsistsAllAfterLastFour task2 = new ReturnArrayConsistsAllAfterLastFour();
  //private checkArrayForContentOneAndFour task3;

  @Test
    public void ShouldReturnArrayConsistsAllAfterLastFour(){
      int[] expected = {1,2,3};
      int[] actual = {4,1,2,3};

      Assertions.assertArrayEquals(expected, task2.getResultArray(actual));
  }


}
