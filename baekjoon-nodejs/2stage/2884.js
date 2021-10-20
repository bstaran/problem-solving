const fs = require("fs");
const input = fs.readFileSync("../test-folder/stdin").toString().split(" ");
let A = parseInt(input[0]);
let B = parseInt(input[1]);
B -= 45;
if (B < 0) {
  A--;
  B += 60;
  if (A < 0) {
    A = 23;
  }
}
console.log(A + " " + B);
