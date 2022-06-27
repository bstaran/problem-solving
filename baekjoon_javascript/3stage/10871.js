const fs = require("fs");
const input = fs.readFileSync("../test-folder/stdin").toString().split("\n");
const [length, n] = input[0].split(" ");
const value = input[1].split(" ");

let result = "";
for (let i = 0; i < length; i++) {
  if (parseInt(value[i]) < n) {
    result += `${value[i]} `;
  }
}
console.log(result);
