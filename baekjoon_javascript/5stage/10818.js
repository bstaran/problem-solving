const fs = require("fs");
const input = fs.readFileSync("../test-folder/stdin").toString().split("\n");
const [N, B] = input;

const arr = B.split(" ");
let min = arr[0];
let max = arr[0];

for (let i = 0; i < N; i++) {
  if (min > parseInt(arr[i])) {
    min = arr[i];
  } else if (max < parseInt(arr[i])) {
    max = arr[i];
  }
}
console.log(min, max);
