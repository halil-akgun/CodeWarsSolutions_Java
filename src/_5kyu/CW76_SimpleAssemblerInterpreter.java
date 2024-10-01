package _5kyu;

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
        System.out.println(interpret(new String[]{"mov a 5", "inc a", "dec a", "dec a", "jnz a -1", "inc a"})); // {a=1}
        System.out.println(interpret(new String[]{"mov a -10", "mov b a", "inc a", "dec b", "jnz a -2"})); // {a=0, b=-20}
        System.out.println(interpret(new String[]{
                "mov a 1", "mov b 1", "mov c 0", "mov d 26", "jnz c 2", "jnz 1 5",
                "mov c 7", "inc d", "dec c", "jnz c -2", "mov c a", "inc a",
                "dec b", "jnz b -2", "mov b c", "dec d", "jnz d -6",
                "mov c 18", "mov d 11", "inc a", "dec d", "jnz d -2",
                "dec c", "jnz c -5"
        })); // {a=318009, b=196418, c=0, d=0}
    }

    public static Map<String, Integer> interpret(String[] program) {

        Map<String, Integer> registers = new HashMap<>();

        for (int i = 0; i < program.length; i++) {
            String[] instructionParts = program[i].split(" ");
            switch (instructionParts[0]) {
                case "mov" -> {
                    try {
                        int a = Integer.parseInt(instructionParts[2]);
                        registers.put(instructionParts[1], a);
                    } catch (Exception e) {
                        registers.put(instructionParts[1], registers.get(instructionParts[2]));
                    }
                }
                case "inc" -> registers.put(instructionParts[1], registers.get(instructionParts[1]) + 1);
                case "dec" -> registers.put(instructionParts[1], registers.get(instructionParts[1]) - 1);
                default -> {
                    if (Character.isDigit(instructionParts[1].charAt(0)) || registers.get(instructionParts[1]) != 0)
                        i = i + Integer.parseInt(instructionParts[2]) - 1;
                }
            }
        }

        return registers;
    }
}
