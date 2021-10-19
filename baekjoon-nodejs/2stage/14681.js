const fs = require("fs");
const input = fs.readFileSync("../test-folder/stdin").toString().split("\n");
const [A, B] = input;
parseInt(A);
console.log(A);

if (A < 0 && B > 0) {
  console.log("2");
} else if (A > 0 && B > 0) {
  console.log("1");
} else if (A < 0 && B < 0) {
  console.log("3");
} else if (A > 0 && B < 0) {
  console.log("4");
}
