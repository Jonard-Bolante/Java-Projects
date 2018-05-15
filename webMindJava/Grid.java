package webMindJava;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents a set of points on a grid
 */
public class Grid extends HashSet<Point> {
    private static final int[][] neighborOffsets = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    private static final int[][] neighborOffsetsAndSelf = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    /**
     * Creates a blank grid.
     */
    public Grid(){
        super();
    }

    /**
     * Creates a grid from a set of points.
     * @param points a set of points.
     */
    public Grid(HashSet<Point> points){
        super(points);
    }

    @Override
    final public String toString() {
        return super.toString();
    }


    /**
     * Creates a grid from a string representation.
     * @param gridString a JSON string representation of the grid.
     */
    public Grid(String gridString){
        if(gridString.equals("[]")) return;
        for(String pointString : gridString.substring(2, gridString.length()-2).split("], \\[")) {
            String[] xyArray = pointString.split(", ");
            add(new Point(Integer.parseInt(xyArray[0]), Integer.parseInt(xyArray[1])));
        }
    }

    /**
     * @return the next iteration of the grid.
     */
    public Grid stepForward() {
        return this.parallelStream().map(point -> Arrays.stream(neighborOffsetsAndSelf)
                .map(offset -> new Point(point.x+offset[0], point.y+offset[1]))
                .collect(Collectors.toCollection(HashSet::new))).<Set<Point>>collect(HashSet::new, Set::addAll, Set::addAll)
                .parallelStream().filter(point -> {
                    Long neighborCount = Arrays.stream(neighborOffsets)
                            .filter(offset -> this.contains(new Point(point.x+offset[0], point.y+offset[1]))).count();
                    return neighborCount == 3 || (neighborCount == 2 && this.contains(point));
                }).collect(Collectors.toCollection(Grid::new));
    }
}