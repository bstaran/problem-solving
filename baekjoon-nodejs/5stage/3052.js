const input = require("fs").readFileSync("../test-folder/stdin").toString().trim().split("\n");

const valueArr = [];
let value;
for (let i = 0; i < input.length; i++) {
  value = input[i] % 42;
  // if (!valueArr.includes(value)) {
  //   valueArr.push(value);
  // }
  if (valueArr.indexOf(value) === -1) valueArr.push(value);
}
console.log(valueArr.length);

// trim()을 안해줘서 문제가 생김.
