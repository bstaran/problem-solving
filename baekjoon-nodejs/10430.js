// /dev/stdin
const fs = require("fs");
const input = fs
  .readFileSync("./test-folder/stdin")
  .toString()
  .split(" ")
  .map((value) => +value);
const a = input[0];
const b = input[1];
const c = input[2];
console.log((a + b) % c);
console.log(((a % c) + (b % c)) % c);
console.log((a * b) % c);
console.log(((a % c) * (b % c)) % c);
