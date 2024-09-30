package _5kyu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
We want to create a simple interpreter of assembler which will support the following instructions:
 - mov x y - copies y (either a constant value or the content of a register) into register x
 - inc x - increases the content of the register x by one
 - dec x - decreases the content of the register x by one
 - jnz x y - jumps to an instruction y steps away (positive means forward, negative means backward,
   y can be a register or a constant), but only if x (a constant or a register) is not zero

Register names are alphabetical (letters only). Constants are always integers (positive or negative).

Note: the jnz instruction moves relative to itself. For example, an offset of -1 would continue at the
previous instruction, while an offset of 2 would skip over the next instruction.

The function will take an input list with the sequence of the program instructions and will execute them.
The program ends when there are no more instructions to execute, then it returns a dictionary
(a table in COBOL) with the contents of the registers.

Also, every inc/dec/jnz on a register will always be preceeded by a mov on the register first,
so you don't need to worry about uninitialized registers.

Example
["mov a 5"; "inc a"; "dec a"; "dec a"; "jnz a -1"; "inc a"]

visualized:
mov a 5
inc a
dec a
dec a
jnz a -1
inc a

The above code will:
 - set register a to 5,
 - increase its value by 1,
 - decrease its value by 2,
 - then decrease its value until it is zero (jnz a -1 jumps to the previous instruction if a is not zero)
 - and then increase its value by 1, leaving register a at 1

So, the function should return:
{a=1}
 */
public class CW76_SimpleAssemblerInterpreter {
    public static void main(String[] args) {
//        System.out.println(interpret(new String[]{"mov a 5", "inc a", "dec a", "dec a", "jnz a -1", "inc a"})); // {a=1}
        System.out.println(interpret(new String[]{"mov a -10", "mov b a", "inc a", "dec b", "jnz a -2"})); //
    }

    public static Map<String, Integer> interpret(String[] program) {

        System.out.println(Arrays.toString(program));

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < program.length; i++) {
            String[] w = program[i].split(" ");
            System.out.println(map);
            switch (w[0]) {
                case "mov" -> {
                    try {
                        int a = Integer.parseInt(w[2]);
                        map.put(w[1], a);
                    } catch (Exception e) {
                        map.put(w[1], map.get(w[2]));
                    }
                }
                case "inc" -> map.put(w[1], map.get(w[1]) + 1);
                case "dec" -> map.put(w[1], map.get(w[1]) - 1);
                default -> {
                    if (map.get(w[1]) != 0)
                        i = i + Integer.parseInt(w[2]) - 1;
                }
            }
        }

        return map;
    }
}
