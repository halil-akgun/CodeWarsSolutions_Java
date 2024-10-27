'use strict';

const fs = require('fs');
const readline = require('readline');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

// Start the readline interface
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let inputString = [];
let currentLine = 0;

rl.on('line', (input) => {
    inputString.push(input.trim());
});

rl.on('close', () => {
    main();
});

/*
 * Complete the 'minOperations' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY arr
 *  2. INTEGER threshold
 *  3. INTEGER d
 */
function minOperations(arr, threshold, d) {
    const operationsMap = new Map();

    for (const num of arr) {
        let current = num; // Start with the current number
        let ops = 0; // Initialize operation count

        // Continue until the current number is less than 0
        while (current >= 0) {
            if (!operationsMap.has(current)) {
                operationsMap.set(current, []);
            }
            operationsMap.get(current).push(ops);

            if (current === 0) break;

            current = Math.floor(current / d); // Use Math.floor for integer division
            ops++;
        }
    }

    let minOps = Infinity; // Set minimum operations to infinity

    console.log(operationsMap);
    // Check if there are enough operations for each value
    for (const [key, opsList] of operationsMap.entries()) {
        if (opsList.length >= threshold) {
            opsList.sort((a, b) => a - b); // Sort in ascending order
            const sumOps = opsList.slice(0, threshold).reduce((acc, val) => acc + val, 0); // Sum the smallest `threshold` operations
            minOps = Math.min(minOps, sumOps); // Update minimum operations
        }
    }

    return minOps === Infinity ? -1 : minOps; // If no equal elements were found, return -1
}

function main() {
    const outputPath = process.env.OUTPUT_PATH || 'output.txt';
    const ws = fs.createWriteStream(outputPath);

    const arrCount = parseInt(inputString[0].trim(), 10);
    let arr = [];

    for (let i = 1; i <= arrCount; i++) {
        const arrItem = parseInt(inputString[i].trim(), 10);
        arr.push(arrItem);
    }

    const threshold = parseInt(inputString[arrCount + 1].trim(), 10);
    const d = parseInt(inputString[arrCount + 2].trim(), 10);

    const result = minOperations(arr, threshold, d);

    ws.write(result + '\n');
    ws.end();
}

console.log('Enter input (you can exit with Ctrl+D or Ctrl+C):');
