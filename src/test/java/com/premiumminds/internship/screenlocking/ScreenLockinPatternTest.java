package com.premiumminds.internship.screenlocking;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2022.
 */
@RunWith(JUnit4.class)
public class ScreenLockinPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public ScreenLockinPatternTest() {
  };

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()  throws InterruptedException, ExecutionException, TimeoutException {
    Future<Integer> count  = new ScreenLockinPattern().countPatternsFrom(3, 2);
    Integer result = count.get(10, TimeUnit.SECONDS);
    assertEquals(result.intValue(), 5);
  }

  @Test
  public void ScreenLockinPatternTestFirst3Length3Test()  throws InterruptedException, ExecutionException, TimeoutException {
    Future<Integer> count  = new ScreenLockinPattern().countPatternsFrom(3, 3);
    Integer result = count.get(10, TimeUnit.SECONDS);
    assertEquals(result.intValue(), 31);
  }

  @Test
  public void PatternAddTest(){
    Pattern pattern = new Pattern(1,2);
    pattern.addNumber(2);
    assertEquals(2, pattern.getPatternLength());
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    assertEquals(list, pattern.getPattern());
  }

  @Test
  public void PatternErrorTest(){
    Pattern pattern = new Pattern(1,2);
    pattern.addNumber(1);
    assertEquals(1, pattern.getPatternLength());
    List<Integer> list = new ArrayList<>();
    list.add(1);
    assertEquals(list, pattern.getPattern());
  }

  @Test
  public void getXTest(){
    Pattern pattern = new Pattern(1,2);
    assertEquals(1, pattern.getMatrixX(2));
    assertEquals(2, pattern.getMatrixX(3));
    assertEquals(0, pattern.getMatrixX(7));
  }

  @Test
  public void getYTest(){
    Pattern pattern = new Pattern(1,2);
    assertEquals(0, pattern.getMatrixY(2));
    assertEquals(0, pattern.getMatrixY(3));
    assertEquals(2, pattern.getMatrixY(7));
  }

  @Test
  public void getMatrixNumberTest(){
    Pattern pattern = new Pattern(1,2);
    assertEquals(1, pattern.getMatrixNumber(0,0));
    assertEquals(2, pattern.getMatrixNumber(1,0));
    assertEquals(4, pattern.getMatrixNumber(0,1));
    assertEquals(8, pattern.getMatrixNumber(1,2));
  }

  @Test
  public void searchPattern(){
    Search search = new Search(new Pattern(1,2));
    assertEquals(5, search.searchPattern());
  }

}