package webMindJava;
import java.util.Objects;

/**
 * Point.java
 *
 * Represents a single point on the grid.
 */
public class Point {
    public final int x, y;

    /**
     * A constructor for a Point object.
     * @param x the x coordinate.
     * @param y the y coordinate
     */
    public Point(int x, int y) {
        this.x = x;
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

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
