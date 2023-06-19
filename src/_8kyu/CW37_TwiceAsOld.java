package _8kyu;

/*
Your function takes two arguments:

1. Current father's age (years)
2. Current age of his son (years)
Сalculate how many years ago the father was twice as old as his son (or in how many years he will be twice as old).
The answer is always greater or equal to 0, no matter if it was in the past, or it is in the future.

public class TwiceAsOldTest {
    @Test
    public void testSomething() {
      assertEquals(30, TwiceAsOld.TwiceAsOld(30,0));
      assertEquals(16, TwiceAsOld.TwiceAsOld(30,7));
      assertEquals(15, TwiceAsOld.TwiceAsOld(45,30));
    }
}
 */
public class CW37_TwiceAsOld {
    public static void main(String[] args) {
        System.out.println(twiceAsOld(45, 30));
    }

    public static int twiceAsOld(int dadYears, int sonYears) {
        int son = 1;
        int dad = dadYears - (sonYears - 1);

        while (son < dad) {
            if (son * 2 == dad) return Math.abs(dad - dadYears);
            son++;
            dad++;
        }
        return 0;
    }
}
