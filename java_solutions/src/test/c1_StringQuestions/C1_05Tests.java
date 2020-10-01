package test.c1_StringQuestions;

import org.junit.Assert;
import org.junit.Test;

import c1_Strings.C1_05;

public class C1_05Tests {
  @Test
  public void insertA1() {
	  final boolean expected = true;
	  final boolean actual = C1_05.oneEdit("hey", "heyy");
	  Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void insertA2() {
	  final boolean expected = true;
	  final boolean actual = C1_05.oneEdit("heyy", "hey");
	  Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void replace_valid1() {
	  final boolean expected = true;
	  final boolean actual = C1_05.oneEdit("hey", "bey");
	  Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void replace_valid2() {
	  final boolean expected = true;
	  final boolean actual = C1_05.oneEdit("bey", "hey");
	  Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void replace_inValid1() {
	  final boolean expected = false;
	  final boolean actual = C1_05.oneEdit("bey", "hhy");
	  Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void replace_inValid2() {
	  final boolean expected = false;
	  final boolean actual = C1_05.oneEdit("hey", "heyyy");
	  Assert.assertEquals(actual, expected);
  }
}
