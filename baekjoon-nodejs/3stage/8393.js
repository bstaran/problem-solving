const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
rl.on("line", (input) => {
  let sum = 0;
  for (let n = 1; n <= input; n++) {
    sum += n;
  }
  console.log(sum);
}).on("close", () => {
  process.exit();
});
