const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let star = "*";
let result = "";
rl.on("line", (line) => {
  for (let n = 1; n <= line; n++) {
    for (let j = 1; j <= n; j++) {
      result += `${star}`;
    }
    result += "\n";
  }
}).on("close", () => {
  console.log(result);
  process.exit();
});
