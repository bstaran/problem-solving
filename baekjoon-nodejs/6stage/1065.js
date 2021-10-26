const input = require("fs").readFileSync("/dev/stdin").toString();

function hansu(input) {
  let cnt = 0;
  for (let i = 1; i <= parseInt(input); i++) {
    if (i > 99) {
      let val;

      for (let j = 0; j < String(i).length; j++) {
        if (val === undefined) {
          val = String(i)[j] - String(i)[j + 1];
        } else {
          if (val === String(i)[j] - String(i)[j + 1]) {
            if (j + 1 === String(i).length - 1) cnt++;
          } else {
            break;
          }
        }
      }
    } else {
      cnt++;
    }
  }
  return cnt;
}
console.log(hansu(input));
