package _6kyu;

import java.util.concurrent.Callable;
import java.util.Collection;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
While writing some code, you ran into a problem. Your code runs very slowly, because you need to run many functions.

You do a bit of troubleshooting and notice that you are not draining your system's resources.

Write a function that, given a list of "slow" functions, will return the sum of the results without waiting
for each function to complete individually.
 */
public class CW44_TaskMaster {
    public static void main(String[] args) {
        SolutionSampleTest test = new SolutionSampleTest();
        test.basic1();
        test.basic2();
        test.basic3();
    }
}

class Solution {
    static int taskMaster(Collection<Callable<Integer>> functions) {

        ExecutorService executor = Executors.newFixedThreadPool(functions.size());
        var sum = 0;

        try {
            List<Future<Integer>> futures = executor.invokeAll(functions);
            for (var future : futures) {
                try {
                    sum += future.get();
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        return sum;
    }
}

class SolutionSampleTest {
    static final Random random = new Random();

    static Callable<Integer> getFunction(long millis, int result) {
        return () -> {
            Thread.sleep(millis);
            return result;
        };
    }

    @Test
    @DisplayName("Basic test")
    void basic1() {
        int expected = 5;
        var functions = List.of(
                getFunction(random.nextLong(1000, 2001), 3),
                getFunction(random.nextLong(1000, 2001), 2)
        );
        int actual = Solution.taskMaster(functions);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Big test with same results")
    void basic2() {
        var functions = new ArrayList<Callable<Integer>>();
        var function = getFunction(random.nextLong(1000, 2001), 3);
        for (int i = 0; i < 10; i++)
            functions.add(function);
        int expected = 30;
        int actual = Solution.taskMaster(List.copyOf(functions));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Big test with different results")
    void basic3() {
        var functions = new ArrayList<Callable<Integer>>();
        var functionA = getFunction(random.nextLong(1000, 2001), 3);
        for (int i = 0; i < 10; i++)
            functions.add(functionA);
        var functionB = getFunction(random.nextLong(1000, 2001), 2);
        for (int i = 0; i < 10; i++)
            functions.add(functionB);
        int expected = 50;
        int actual = Solution.taskMaster(List.copyOf(functions));
        assertEquals(expected, actual);
    }
}