// 문자열 풀이로 접근
// 코드가 매우 난잡해짐.

const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let cycleNumber = 0;
rl.on("line", (input) => {
  let A, B;
  if (input.length < 2) {
    A = "0";
    B = input;
  } else {
    [A, B] = input.split("");
  }
  const answer = parseInt(input);

  let result;
  while (!(answer === parseInt(result))) {
    A = parseInt(A);
    B = parseInt(B);
    let addValue = A + B;
    if (addValue >= 10) {
      let [newA, newB] = addValue.toString().split("");
      result = B.toString() + newB;
    } else {
      result = B.toString() + addValue.toString();
    }
    [A, B] = result.split("");
    cycleNumber++;
  }
}).on("close", () => {
  console.log(cycleNumber);
  process.exit();
});
