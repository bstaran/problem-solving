const fs = require("fs");
const input = fs.readFileSync("../test-folder/stdin").toString();

if (input % 4 === 0 && input % 100 !== 0) {
  console.log("1");
} else if (input % 400 === 0) {
  console.log("1");
} else {
  console.log("0");
}

// 100의 배수와 400의 배수의 겹치는 경우의 수를 주의
