const fs = require("fs");
const input = fs.readFileSync("./test-folder/stdin").toString().split("\n");
const [A, B] = input;
const [B1, B10, B100] = B.split("");
console.log(A * B100);
console.log(A * B10);
console.log(A * B1);
console.log(A * B);
