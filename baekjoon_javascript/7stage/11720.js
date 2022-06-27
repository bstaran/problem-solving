const input = require("fs").readFileSync("../test-folder/stdin").toString().split("\n");
const [length, inputArr] = input;

let sum = 0;
for (let i = 0; i < parseInt(length); i++) {
  sum += parseInt(inputArr[i]);
}
console.log(sum);
