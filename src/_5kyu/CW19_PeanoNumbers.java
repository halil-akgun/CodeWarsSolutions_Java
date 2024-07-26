package _5kyu;

import org.junit.Test;

import static _5kyu.PeanoNumbers.Ordering.EQ;
import static _5kyu.PeanoNumbers.Ordering.GT;
import static _5kyu.PeanoNumbers.Ordering.LT;
import static _5kyu.PeanoNumbers.add;
import static _5kyu.PeanoNumbers.compare;
import static _5kyu.PeanoNumbers.div;
import static _5kyu.PeanoNumbers.even;
import static _5kyu.PeanoNumbers.mul;
import static _5kyu.PeanoNumbers.odd;
import static _5kyu.PeanoNumbers.sub;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
Peano numbers are a simple way of representing the natural numbers using only a zero value
and a successor function. We can represent Peano numbers as follows:

interface Peano {
  final class Zero implements Peano {
    static Zero INSTANCE = new Zero();
    private Zero() {}
  }

  final class Succ implements Peano {
    final Peano peano;
    Succ(Peano peano) {
      this.peano = peano;
    }
  }
}

where:
0 is represented by Zero.INSTANCE
1 is represented by Succ(Zero.INSTANCE)
2 is represented by Succ(Succ(Zero.INSTANCE))
3 is represented by Succ(Succ(Succ(Zero.INSTANCE)))
etc.

Your mission in this Kata is to implement the following static operations with peano numbers:
add(Peano a, Peano b) Addition
sub(Peano a, Peano b) Subtract (ArithmeticException: "negative number")
mul(Peano a, Peano b) Multiplication
div(Peano a, Peano b) Integer division (ArithmeticException: "divide by 0")
even(Peano a) Even number
odd(Peano a) Odd number
compare(Peano a, Peano b) Compare (LT, GT or EQ)
 */
public class CW19_PeanoNumbers {

    private static PeanoNumbers.Peano peano(int n) {
        if (0 == n) return PeanoNumbers.Peano.Zero.INSTANCE;
        return new PeanoNumbers.Peano.Succ(peano(n - 1));
    }

    private static void assertPeanoEq(PeanoNumbers.Peano a, PeanoNumbers.Peano b) {
        assertEquals(EQ, compare(a, b));
    }

    @Test
    public void addTest() throws Exception {
        assertPeanoEq(peano(0), add(peano(0), peano(0)));
        assertPeanoEq(peano(664), add(peano(0), peano(664)));
    }

    @Test
    public void subTest() throws Exception {
        assertPeanoEq(peano(0), sub(peano(0), peano(0)));
        assertPeanoEq(peano(10), sub(peano(10), peano(0)));
    }

    @Test
    public void mulTest() throws Exception {
        assertPeanoEq(peano(0), mul(peano(0), peano(0)));
        assertPeanoEq(peano(0), mul(peano(5), peano(0)));
    }

    @Test
    public void divTest() throws Exception {
        assertPeanoEq(peano(4), div(peano(8), peano(2)));
        assertPeanoEq(peano(3), div(peano(10), peano(3)));
    }

    @Test
    public void evenTest() throws Exception {
        assertTrue(even(peano(0)));
        assertTrue(even(peano(8)));
    }

    @Test
    public void oddTest() throws Exception {
        assertFalse(odd(peano(0)));
        assertFalse(odd(peano(8)));
    }

    @Test
    public void compareTest() throws Exception {
        assertEquals(LT, compare(peano(0), peano(4)));
        assertEquals(GT, compare(peano(210), peano(43)));
        assertEquals(EQ, compare(peano(0), peano(0)));
    }
}

final class PeanoNumbers {
    interface Peano {
        final class Zero implements Peano {
            static Zero INSTANCE = new Zero();

            private Zero() {
            }
        }

        final class Succ implements Peano {
            final Peano peano;

            Succ(Peano peano) {
                this.peano = peano;
            }

            public Peano getPeano() {
                return peano;
            }
        }
    }

    enum Ordering {GT, LT, EQ}

    static Peano add(Peano a, Peano b) {
        if (a instanceof Peano.Zero) {
            return b;
        } else if (a instanceof Peano.Succ) {
            return new Peano.Succ(add(((Peano.Succ) a).getPeano(), b));
        }
        throw new IllegalArgumentException("Unknown Peano number type");
    }

    static Peano sub(Peano a, Peano b) {
        if (b instanceof Peano.Zero) {
            return a;
        } else if (a instanceof Peano.Zero) {
            throw new ArithmeticException("negative number");
        } else if (a instanceof Peano.Succ && b instanceof Peano.Succ) {
            return sub(((Peano.Succ) a).getPeano(), ((Peano.Succ) b).getPeano());
        }
        throw new IllegalArgumentException("Unknown Peano number type");
    }

    static Peano mul(Peano a, Peano b) {
        if (b instanceof Peano.Zero) {
            return Peano.Zero.INSTANCE;
        } else if (b instanceof Peano.Succ) {
            return add(mul(a, ((Peano.Succ) b).getPeano()), a);
        }
        throw new IllegalArgumentException("Unknown Peano number type");
    }

    static Peano div(Peano a, Peano b) {
        if (b instanceof Peano.Zero) {
            throw new ArithmeticException("divide by 0");
        } else if (a instanceof Peano.Zero) {
            return Peano.Zero.INSTANCE;
        } else {
            return divHelper(a, b, Peano.Zero.INSTANCE);
        }
    }

    static Peano divHelper(Peano a, Peano b, Peano count) {
        if (a instanceof Peano.Zero) {
            return count;
        } else {
            try {
                Peano result = sub(a, b);
                return divHelper(result, b, new Peano.Succ(count));
            } catch (ArithmeticException e) {
                return count;
            }
        }
    }

    static boolean even(Peano peano) {
        if (peano instanceof Peano.Zero) {
            return true;
        } else if (peano instanceof Peano.Succ) {
            return !even(((Peano.Succ) peano).getPeano());
        }
        throw new IllegalArgumentException("Unknown Peano number type");
    }

    static boolean odd(Peano peano) {
        if (peano instanceof Peano.Zero) {
            return false;
        } else if (peano instanceof Peano.Succ) {
            return !odd(((Peano.Succ) peano).getPeano());
        }
        throw new IllegalArgumentException("Unknown Peano number type");
    }

    static Ordering compare(Peano a, Peano b) {
        if (a instanceof Peano.Zero && b instanceof Peano.Zero) {
            return Ordering.EQ;
        } else if (a instanceof Peano.Zero) {
            return Ordering.LT;
        } else if (b instanceof Peano.Zero) {
            return Ordering.GT;
        } else if (a instanceof Peano.Succ && b instanceof Peano.Succ) {
            return compare(((Peano.Succ) a).getPeano(), ((Peano.Succ) b).getPeano());
        }
        throw new IllegalArgumentException("Unknown Peano number type");
    }
}
