const input = require("fs").readFileSync("/Users/anbyeong-gyu/Dev/algorithm-study/baekjoon-nodejs/test-folder/stdin").toString().split("\n");

for (let i = 1; i <= input[0]; i++) {
  let cnt = 0;
  let sum = 0;
  const length = input[i].length;
  for (let j = 0; j < length; j++) {
    if (input[i][j] === "O") {
      cnt++;
      sum += cnt;
    } else {
      cnt = 0;
    }
  }
  console.log(sum);
}
// 문자열은 char의 배열 형태이다.
