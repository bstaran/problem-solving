const input = require("fs").readFileSync("../test-folder/stdin").toString();

// const answerArr = new Array(26).fill(-1);
// const alpaArr = Array(26)
//   .fill()
//   .map((item, i) => {
//     return "a".charCodeAt() + i;
//   });

// for (let i = 0; i < input.length; i++) {
//   alpaArr.forEach((el, index) => {
//     if (input[i] === String.fromCharCode(el) && answerArr[index] === -1) {
//       answerArr[index] = i;
//     }
//   });
// }
// let result = "";
// answerArr.forEach((el, i) => {
//   i === 0 ? (result += el) : (result += ` ${el}`);
// });
// console.log(result);

const answerArr = [];

for (let i = 97; i < 123; i++) {
  answerArr.push(input.indexOf(String.fromCharCode(i)));
}

console.log(answerArr.join(" "));
