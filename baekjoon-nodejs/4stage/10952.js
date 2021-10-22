const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let result = "";
rl.on("line", (input) => {
  let [A, B] = input.split(" ");
  A = parseInt(A);
  B = parseInt(B);

  while (!(A === 0 && B === 0)) {
    result += A + B + "\n";
    return;
  }
}).on("close", () => {
  console.log(result);
  process.exit();
});
