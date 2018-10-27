package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import StringQuestions.Q1_05;

public class Q1_05Tests {
  @Test
  public void insertA1() {
	  final boolean expected = true;
	  final boolean actual = Q1_05.oneEdit("hey", "heyy");
	  Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void insertA2() {
	  final boolean expected = true;
	  final boolean actual = Q1_05.oneEdit("heyy", "hey");
	  Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void replace_valid1() {
	  final boolean expected = true;
	  final boolean actual = Q1_05.oneEdit("hey", "bey");
	  Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void replace_valid2() {
	  final boolean expected = true;
	  final boolean actual = Q1_05.oneEdit("bey", "hey");
	  Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void replace_inValid1() {
	  final boolean expected = false;
	  final boolean actual = Q1_05.oneEdit("bey", "hhy");
	  Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void replace_inValid2() {
	  final boolean expected = false;
	  final boolean actual = Q1_05.oneEdit("hey", "heyyy");
	  Assert.assertEquals(actual, expected);
  }
}
