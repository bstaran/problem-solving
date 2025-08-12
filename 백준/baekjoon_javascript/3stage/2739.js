const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
rl.on("line", (input) => {
  for (let n = 1; n <= 9; n++) {
    console.log(`${input} * ${n} = ${input * n}`);
  }
}).on("close", () => {
  process.exit();
});
