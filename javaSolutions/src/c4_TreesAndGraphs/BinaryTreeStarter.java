package c4_TreesAndGraphs;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class BinaryTreeStarter {



    // tests

    @Test
    public void test() {
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BinaryTreeNode.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}