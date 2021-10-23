const fs = require("fs");
const input = fs.readFileSync("../test-folder/stdin").toString().split("\n");

const sum = String(input[0] * input[1] * input[2]);

let result = "";
for (let i = 0; i < 10; i++) {
  result += `${sum.split(i).length - 1}\n`;
}
console.log(result);
