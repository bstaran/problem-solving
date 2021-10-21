const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let result = "";
rl.on("line", (input) => {
  let [A, B] = input.split(" ");
  if (A === undefined || B === undefined) {
    return;
  }
  A = parseInt(A);
  B = parseInt(B);
  result += A + B + "\n";
}).on("close", () => {
  console.log(result);
  process.exit();
});

// 변수에 값 없이 초기화 시 undefined 할당됨.
