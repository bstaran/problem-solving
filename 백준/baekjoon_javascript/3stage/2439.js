const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let star = "*";
let result = "";
rl.on("line", (input) => {
  for (let n = 1; n <= input; n++) {
    for (let j = input - n; j > 0; j--) {
      result += " ";
    }
    for (let k = 1; k <= n; k++) {
      result += star;
    }
    result += "\n";
  }
}).on("close", () => {
  console.log(result);
  process.exit();
});
