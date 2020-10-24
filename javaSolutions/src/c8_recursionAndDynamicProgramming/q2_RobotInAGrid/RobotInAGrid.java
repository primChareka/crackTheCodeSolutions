package c8_recursionAndDynamicProgramming.q2_RobotInAGrid;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class RobotInAGrid {

    private static class Point {
        int col;
        int row;

        public Point(int col, int row) {
            this.col = col;
            this.row = row;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return col == point.col &&
                    row == point.row;
        }

        @Override
        public int hashCode() {
            return Objects.hash(col, row);
        }
    }

    public static ArrayList<Point> findPath(int[][] grid, int rows, int cols) {
        if (grid == null || grid.length == 0)
            return null;
        ArrayList<Point> path = new ArrayList<>();

        return tryThisPath(grid, rows, cols, 0, 0, path);
    }

    public static ArrayList<Point> tryThisPath(int[][] grid, int rows, int cols, int c, int r, ArrayList<Point> path) {
        if (c == cols - 1 && r == rows - 1 && grid[r][c] == 1) {
            Point p = new Point(c, r);
            path.add(p);
            return path; //we are at the bottom most right square and the value is 1;
        }
        if (grid[r][c] == 0)
            return null;

        if (c + 1 == cols)
            return null;

        if (tryThisPath(grid, rows, cols, c + 1, r, path) == null) {

            if (r + 1 == rows)
                return null;

            if (tryThisPath(grid, rows, cols, c, r + 1, path) == null)
                return null;
        }

        Point p = new Point(c, r);
        path.add(p);
        return path;
    }

    @Test
    public void testClearPathIterative() {
        int rows = 5;
        int cols = 5;
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };

        ArrayList<Point> result = findPath(grid, rows, cols);
        ArrayList<Point>  expected = new ArrayList<>();
        expected.add(new Point(0,0));
        expected.add(new Point(1,0));
        expected.add(new Point(2,0));
        expected.add(new Point(3,0));
        expected.add(new Point(3,1));
        expected.add(new Point(3,2));
        expected.add(new Point(3,3));
        expected.add(new Point(3,4));
        expected.add(new Point(4,4));
        Collections.reverse(expected);
        Assert.assertEquals(expected.size(), result.size());
        Assert.assertArrayEquals(expected.toArray(),result.toArray());
    }

    @Test
    public void testOnePathIterative() {
        int rows = 5;
        int cols = 5;
        int[][] grid = {
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1},
        };

        ArrayList<Point> result = findPath(grid, rows, cols);
        ArrayList<Point>  expected = new ArrayList<>();
        expected.add(new Point(0,0));
        expected.add(new Point(0,1));
        expected.add(new Point(0,2));
        expected.add(new Point(1,2));
        expected.add(new Point(2,2));
        expected.add(new Point(2,3));
        expected.add(new Point(3,3));
        expected.add(new Point(3,4));
        expected.add(new Point(4,4));
        Collections.reverse(result);
        Assert.assertEquals(expected.size(), result.size());
        Assert.assertArrayEquals(expected.toArray(),result.toArray());
    }

    @Test
    public void testOneBlockedCellIterative() {
        int rows = 5;
        int cols = 5;
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1}
        };

        ArrayList<Point> result = findPath(grid, rows, cols);
        ArrayList<Point>  expected = new ArrayList<>();
        expected.add(new Point(0,0));
        expected.add(new Point(1,0));
        expected.add(new Point(2,0));
        expected.add(new Point(3,0));
        expected.add(new Point(3,1));
        expected.add(new Point(3,2));
        expected.add(new Point(3,3));
        expected.add(new Point(3,4));
        expected.add(new Point(4,4));
        Collections.reverse(expected);

        Assert.assertEquals(expected.size(), result.size());
        Assert.assertArrayEquals(expected.toArray(),result.toArray());
    }

    @Test
    public void testNoPathIterative() {
        int rows = 5;
        int cols = 5;
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 1},
                {1, 0, 0, 1, 0},
                {1, 1, 1, 1, 1}
        };

        ArrayList<Point> result = findPath(grid, rows, cols);
        Assert.assertNull(result);
    }

    @Test
    public void testAllBlockedCellIterative() {
        int rows = 5;
        int cols = 5;
        int[][] grid = {
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };

        ArrayList<Point> result = findPath(grid, rows, cols);
        Assert.assertNull(result);
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(RobotInAGrid.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

}
