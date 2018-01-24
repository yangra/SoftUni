function DNAHelix(num) {
    let DNA = ['A', 'T', 'C', 'G', 'T', 'T', 'A', 'G', 'G', 'G'];
    let index = 0;
    for (let i = 0; i < num; i++) {
        let line = '';
        if (i % 4 === 0) {
            line += '**';
            line += DNA[index++ % DNA.length];
            line += DNA[index++ % DNA.length];
            line += '**';
        }

        if (i % 4 === 1 || i % 4 === 3) {
            line += '*';
            line += DNA[index++ % DNA.length];
            line += '--';
            line += DNA[index++ % DNA.length];
            line += '*';
        }

        if (i % 4 === 2) {
            line += DNA[index++ % DNA.length];
            line += '----';
            line += DNA[index++ % DNA.length];
        }
        console.log(line);
    }
}

DNAHelix(4);
DNAHelix(10);