const result = [];
const answer = [];

function d(n) {
  let val = 0;
  let number = String(n);
  for (let i = 0; i < number.length; i++) {
    val += Number(number[i]);
  }
  val += n;

  // val = n + parseInt(n / 1000) + parseInt((n % 1000) / 100) + parseInt((n % 100) / 10) + (n % 10);

  if (val <= 10000) d(val);
  if (result.indexOf(val) === -1) {
    result.push(val);
  }
}
for (let i = 1; i < 10000; i++) {
  d(i);
}
for (let i = 1; i <= 10000; i++) {
  if (result.indexOf(i) === -1) answer.push(i);
}
console.log(answer.join("\n"));
