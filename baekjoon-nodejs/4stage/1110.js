const input = require("fs").readFileSync("../test-folder/stdin").toString();

let cycleNumber = 0;
let value = parseInt(input);

while (true) {
  let sum = Math.floor(value / 10) + (value % 10);
  value = (value % 10) * 10 + (sum % 10);
  cycleNumber++;
  if (value === parseInt(input)) {
    break;
  }
}
console.log(cycleNumber);
