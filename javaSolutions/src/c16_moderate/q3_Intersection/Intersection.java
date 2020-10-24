package c16_moderate.q3_Intersection;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Objects;

public class Intersection {
    private static class Point {
        double x;
        double y;

        public Point(double col, double y) {
            this.x = col;
            this.y = y;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static class Line {
        Point start;
        Point end;
        double slope;
        double y_intercept;

        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
            this.slope = slope(start,end);
            this.y_intercept= start.y-slope*start.x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return Objects.equals(start, line.start) &&
                    Objects.equals(end, line.end);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }


    public static Point pointOfIntersection(Line l1, Line l2) {
        Line leftMost = l1.start.x < l2.start.x ? l1 : l2;
        Line rightMost = l1.start.x > l2.start.x ? l1 : l2;

        Line lowest = l1.start.y<l2.start.y? l1:l2;
        Line highest = l1.start.y>l2.start.y? l1:l2;

        if(rightMost.start.x>leftMost.end.x)
            return null;

        if(highest.start.y>lowest.end.y)
            return null;

        Point intersection = new Point (rightMost.start.x,highest.start.y);
        return intersection;
    }

    public static double slope(Point start, Point end){
        double rise = end.y - start.y;
        double run = end.x - start.x;

        return rise/run;
    }

    @Test
    public void intersect() {
        Point start1 = new Point(1, 1);
        Point end1 = new Point(7, 1);
        Line line1 = new Line(start1, end1);

        Point start2 = new Point(4, 0);
        Point end2 = new Point(4, 5);
        Line line2 = new Line(start2, end2);

        Point expected = new Point(4, 1);
        Point result = pointOfIntersection(line1, line2);

        Assert.assertEquals(expected, result);
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Intersection.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

}
