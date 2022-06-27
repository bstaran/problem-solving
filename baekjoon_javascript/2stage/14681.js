// const fs = require("fs");
// const input = fs.readFileSync("../test-folder/stdin").toString();
// const [A, B] = input;
const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
const input = [];
rl.on("line", (answer) => {
  input.push(answer);
}).on("close", () => {
  const A = parseInt(input[0]);
  const B = parseInt(input[1]);

  if (A < 0 && B > 0) {
    console.log("2");
  } else if (A > 0 && B > 0) {
    console.log("1");
  } else if (A < 0 && B < 0) {
    console.log("3");
  } else if (A > 0 && B < 0) {
    console.log("4");
  }

  process.exit();
});

// fs 모듈을 사용한 파일 접근이 불가능했기 때문에 readline을 통한 입력값을 받음.
