
'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the freqQuery function below.
function freqQuery(queries) {
  const map = {};
  const freqMap = {};
  let list = [];
  for(let i = 0; i < queries.length; i++) {
    if(queries[i][0] === 1) {
      const x = queries[i][1];
      if(map[x] === undefined) {
        map[x] = 0;
      }
      const f = map[x];
      if(f !== 0) {
        freqMap[f]--;
      }
      map[x]++;
      if(freqMap[f + 1] === undefined) {
        freqMap[f + 1] = 0;
      }
      freqMap[f + 1]++;
    } else if(queries[i][0] === 2) {
      const y = queries[i][1];
      if(map[y] !== undefined && map[y] > 0) {
        map[y]--;
        const f = map[y];
        if(f != 0) {
          if(freqMap[f] === undefined) {
            freqMap[f] = 0;
          }
          freqMap[f]++;
        }
        freqMap[f + 1]--;
      }
    } else if(queries[i][0] == 3) {
      const z = queries[i][1];
      if(freqMap[z] !== undefined && freqMap[z] > 0) {
        list.push(1);
      } else {
        list.push(0);
      }
    }
  }
  return list;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const q = parseInt(readLine().trim(), 10);

    let queries = Array(q);

    for (let i = 0; i < q; i++) {
        queries[i] = readLine().replace(/\s+$/g, '').split(' ').map(queriesTemp => parseInt(queriesTemp, 10));
    }

    const ans = freqQuery(queries);

    ws.write(ans.join('\n') + '\n');

    ws.end();
}
