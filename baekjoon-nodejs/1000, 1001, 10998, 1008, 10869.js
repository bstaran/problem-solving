const fs = require("fs");
const input = fs.readFileSync("//dev/stdin").toString().split(" ");

// A+B
console.log(parseInt(input[0]) + parseInt(input[1]));

// A-B
console.log(parseInt(input[0]) - parseInt(input[1]));

// A*B
console.log(parseInt(input[0]) * parseInt(input[1]));

// A/B
console.log(parseInt(input[0]) / parseInt(input[1]));

// 사칙연산
console.log(parseInt(input[0]) + parseInt(input[1]));
console.log(parseInt(input[0]) - parseInt(input[1]));
console.log(parseInt(input[0]) * parseInt(input[1]));
console.log(Math.floor(parseInt(input[0]) / parseInt(input[1])));
console.log(parseInt(input[0]) % parseInt(input[1]));
