package test.c2_LinkedLists.SingleLinked;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import template.c2_LinkedLists.SinglyLinked.C2_01_SL;

public class ModelTest {
    private C2_01_SL C2_01_Obj;

    @Before
    public void setup() {
        C2_01_Obj = new C2_01_SL();
    }

    @Test
    public void insertAndPrintTest() {
        C2_01_Obj.linkedList.insert(1);
        C2_01_Obj.linkedList.insert(2);
        C2_01_Obj.linkedList.insert(3);

        String expected = "[1->2->3]";

        String actual = C2_01_Obj.linkedList.toString();

        System.out.println(actual);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void printEmptyTest() {
        String expected = "[]";
        String actual = C2_01_Obj.linkedList.toString();

        Assert.assertEquals(actual, expected);
    }
}
