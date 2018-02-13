function decryptMessage(text) {
    let regex = /^<message((?:\s*[a-z]+="[a-zA-Z0-9 .]+")+)>((?:.|\s)+)<\/message>$/;
    let match = regex.exec(text);
    let toPattern = /\bto="([a-zA-Z0-9 .]+)"/;
    let fromPattern = /\bfrom="([a-zA-Z0-9 .]+)"/;
    if (match) {
        let attributes = match[1];
        let to = toPattern.exec(attributes)?toPattern.exec(attributes)[1]:null;
        let from = fromPattern.exec(attributes)?fromPattern.exec(attributes)[1]:null;
        if (to!==null && from!==null) {
            let output = '<article>\n  <div>';
            output += `From: <span class="sender">${from}</span></div>\n`;
            output += `  <div>To: <span class="recipient">${to}</span></div>\n`;
            output += `  <div>\n`;
            for (let message of match[2].split(/\n/)) {
                output += `    <p>${message}</p>\n`;
            }
            output += '  </div>\n</article>';
            console.log(output);
        } else {
            console.log('Missing attributes');
        }
    } else {
        console.log('Invalid message format');
    }
}

//decryptMessage('<message to="Bob" from="Alice" timestamp="1497254092">Hey man, what\'s up?</message>');
//decryptMessage('<message from="John Doe" to="Alice">Not much, just chillin. How about you?</message>');
//decryptMessage('<message from="Alice" timestamp="1497254112">Same old, same old</message>');
//decryptMessage('<message to="Alice" from="Charlie"><img src="fox.jpg"/></message><meta version="2"/>');
//decryptMessage('<message from="Hillary" to="Edward" secret:true>VGhpcyBpcyBhIHRlc3Q</message>');
// decryptMessage('<message to="Bob" from="Alice" timestamp="1497254114">Same old, same old\n' +
//      'Let\'s go out for a beer</message>');
decryptMessage('<message mailto="everyone" from="Grandma" to="Everyone">FWD: FWD: FWD: FWD: Forwards from grandma</message>');

