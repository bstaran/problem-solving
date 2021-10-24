const input = require("fs").readFileSync("../test-folder/stdin").toString().split("\n");
const subNum = input[0];
const subScore = input[1].split(" ");

const maxScore = Math.max(...subScore);
let sum = 0;
for (let i = 0; i < subScore.length; i++) {
  sum += (subScore[i] / maxScore) * 100;
}
console.log(sum / subNum);
