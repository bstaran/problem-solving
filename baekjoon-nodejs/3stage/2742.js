const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let result = "";
rl.on("line", (input) => {
  for (let n = input; n > 0; n--) {
    result += `${n}\n`;
  }
}).on("close", () => {
  console.log(result);
  process.exit();
});
