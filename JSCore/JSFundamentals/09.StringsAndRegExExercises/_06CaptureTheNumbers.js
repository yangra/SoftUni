function captureNumbers(strings) {
    let regex = /\d+/g;
    let output = [];
    for (let str of strings) {
        let match = regex.exec(str);
        while (match) {
            output.push(match[0]);
            match = regex.exec(str);
        }
        // let matches = str.match(regex);
        // if (matches !== null) {
        //     matches.forEach(m=>output.push(m));
        // }
    }

    console.log(output.join(' '));
}

captureNumbers(['The300', 'What is that?', 'I think it’s the 3rd movie.', 'Lets watch it at 22:45']);
captureNumbers(['123a456', '789b987', '654c321', '0']);
captureNumbers(['Let’s go11!!!11!', 'Okey!1!    ']);