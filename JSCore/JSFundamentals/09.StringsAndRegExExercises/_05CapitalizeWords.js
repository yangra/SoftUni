function capitalize(text) {
    let words = text.split(' ').map(w => w.substr(0, 1).toUpperCase() + w.substr(1).toLowerCase());
    console.log(words.join(' '));
    // let output = '';
    //
    // while (text.indexOf(' ') >= 0) {
    //     output += text
    //         .substring(0, text.indexOf(' '))
    //         .split('')
    //         .map((l, i) => i === 0 ? l.toUpperCase() : l.toLowerCase())
    //         .join('') + ' ';
    //     text = text.substr(text.indexOf(' ') + 1);
    // }
    //
    // output += text.split('')
    //     .map((l, i) => i === 0 ? l.toUpperCase() : l.toLowerCase())
    //     .join('');
    //
    // console.log(output);
}

capitalize('Capitalize these words');
capitalize('Was that Easy? tRY thIs onE for SiZe!');