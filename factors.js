const fs = require('fs');

function factorize(n) {
    let i = 2;
    while (i * i <= n) {
        if (n % i === 0) {
            return [i, n / i];
        }
        i++;
    }
    return [null, null];
}

function main(filePath) {
    const numbers = fs.readFileSync(filePath, 'utf8').split('\n');

    for (const numStr of numbers) {
        const num = parseInt(numStr, 10);
        const [p, q] = factorize(num);
        if (p !== null && q !== null) {
            console.log(`${num}=${p}*${q}`);
        }
    }
}

if (process.argv.length !== 3) {
    console.log('Usage: node script.js input.txt');
    process.exit(1);
}

const filePath = process.argv[2];
main(filePath);

