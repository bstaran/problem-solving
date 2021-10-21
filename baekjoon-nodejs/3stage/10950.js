const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
rl.on("line", (input) => {
  let [A, B] = input.split(" ");
  if (A === undefined || B === undefined) {
    return;
  }
  A = parseInt(A);
  B = parseInt(B);
}).on("close", () => {
  process.exit();
});
