package webMindJava;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class GridTest {
    @Test
    public void testStepForward() {
        Grid grid1 = new Grid("[[1, 1], [0, 0], [1, 0]]");
        assertEquals(new Grid("[[1, 0], [0, 0], [1, 1], [0, 1]]"), grid1.stepForward());

        Grid grid2 = new Grid();
        grid2.add(new Point(0, 1));
        grid2.add(new Point(0, 0));
        grid2.add(new Point(0, -1));
        assertEquals(new Grid("[[1, 0], [0, 0], [-1, 0]]"), grid2.stepForward());

        Grid grid3 = new Grid("[]");
        assertEquals(new Grid("[]"), grid3.stepForward());

        Grid grid4 = new Grid();
        grid4.add(new Point(1, 1));
        grid4.add(new Point(0, 0));
        grid4.add(new Point(-1, -1));
        assertEquals(new Grid("[[0, 0]]"), grid4.stepForward());

        Grid grid5 = new Grid();
        grid5.add(new Point(0, 0));
        grid5.add(new Point(1, 1));
        grid5.add(new Point(-1, 1));
        grid5.add(new Point(1, -1));
        grid5.add(new Point(-1, -1));
        assertEquals(new Grid("[[0, -1], [1, 0], [0, 1], [-1, 0]]"), grid5.stepForward());

        Grid grid6 = new Grid();
        grid6.add(new Point(0, 0));
        grid6.add(new Point(1, 1));
        grid6.add(new Point(-1, 1));
        grid6.add(new Point(1, -1));
        grid6.add(new Point(-1, -1));
        grid6.add(new Point(-2, 2));
        grid6.add(new Point(0, 2));
        grid6.add(new Point(2, 2));
        grid6.add(new Point(-2, -2));
        grid6.add(new Point(0, -2));
        grid6.add(new Point(2, -2));
        grid6.add(new Point(-2, 0));
        grid6.add(new Point(2, 0));
        assertEquals(new Grid("[[2, 1], [-1, -2], [-2, -1], [1, 2], [-2, 0], [0, 2], [-2, 1], [-1, 2], [1, -2], [2, -1], [0, -2], [2, 0]]"), grid6.stepForward());

        Grid grid7 = new Grid();
        grid7.add(new Point(1, 1));
        grid7.add(new Point(1, 0));
        grid7.add(new Point(0, 1));
        grid7.add(new Point(-1, 1));
        grid7.add(new Point(-2, 1));
        grid7.add(new Point(-2, 0));
        grid7.add(new Point(-2, -1));
        grid7.add(new Point(-2, -2));
        grid7.add(new Point(-1, -2));
        grid7.add(new Point(1, -2));
        grid7.add(new Point(1, -1));
        grid7.add(new Point(0, -2));
        assertEquals(new Grid("[[1, 0], [-1, -2], [-2, -2], [1, 1], [0, 1], [-2, -1], [0, 2], [-2, 0], [-3, -1], [-1, 1], [-2, 1], [-1, 2], [-3, 0], [1, -2], [2, -1], [0, -3], [1, -1], [-1, -3], [2, 0], [0, -2]]"), grid7.stepForward());
    }

    @Test
    public void testPerformance() {
        Grid grid = IntStream.range(0, 1000)
                .mapToObj(idx -> new Point((int) (Math.random() * 1000), (int) (Math.random() * 1000)))
                .collect(Collectors.toCollection(Grid::new));
        long start = System.currentTimeMillis();
        grid.stepForward();
        long finish = System.currentTimeMillis();
        assertTrue(finish - start < 200);
    }
}