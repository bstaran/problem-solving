const input = require("fs").readFileSync("/Users/anbyeong-gyu/Dev/algorithm-study/baekjoon-nodejs/test-folder/stdin").toString().split("\n");

const testCaseNumber = input[0];
let sum = 0;

for (let n = 1; n <= testCaseNumber; n++) {
  let score = input[n].split(" ");
  for (let i = 1; i <= score[0]; i++) {
    sum += parseInt(score[i]);
  }
  const avg = sum / score[0];
  let cnt = 0;
  for (let i = 1; i <= score[0]; i++) {
    if (score[i] > avg) {
      cnt++;
    }
  }
  console.log(((cnt / score[0]) * 100).toFixed(3) + "%");
  sum = 0;
}
