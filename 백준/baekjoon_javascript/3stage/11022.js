const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let result = "";
let n = 1;
rl.on("line", (input) => {
  let [A, B] = input.split(" ");
  if (A === undefined || B === undefined) {
    return;
  }
  A = parseInt(A);
  B = parseInt(B);
  result += `Case #${n}: ${A} + ${B} = ${A + B}\n`;
  n++;
}).on("close", () => {
  console.log(result);
  process.exit();
});
