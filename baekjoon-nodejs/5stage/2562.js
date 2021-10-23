const fs = require("fs");
const inputArr = fs.readFileSync("../test-folder/stdin").toString().split("\n");

let val = {
  max: 0,
  index: 0,
};
for (let i = 0; i < inputArr.length; i++) {
  if (val.max < parseInt(inputArr[i])) {
    val.max = parseInt(inputArr[i]);
    val.index = i + 1;
  }
}
console.log(`${val.max}\n${val.index}`);
