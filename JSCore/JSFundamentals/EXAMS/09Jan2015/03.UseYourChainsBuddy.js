function decypher(arr) {
    let result = '';
    let matches = arr[0].match(/<p>.*?<\/p>/g)
        .map(m => m.slice(3, m.length - 4));
    for (let match of matches) {
        match = match.replace(/[^a-z0-9]/g, ' ');
        for (let letter of match) {
            let code = letter.charCodeAt(0);
            if (code >= 97 && code <= 122) {
                if (code < 110) {
                    result += String.fromCharCode(code + 13);

                } else {
                    result += String.fromCharCode(code - 13);
                }
                continue;
            }
            result += letter;
        }
    }
    result = result.replace(/\s+/g, ' ');
    console.log(result);
}

decypher(['<html><head><title></title></head><body><h1>hello</h1><p>znahny!@#%&&&&****</p><div><button>dsad</button></div><p>grkg^^^^%%%)))([]12</p></body></html>','']);
decypher(['<html><head><title></title></head><body><h1>Intro</h1><ul><li>Item01</li><li>Item02</li><li>Item03</li></ul><p>jura qevivat va jrg fyvccrel fabjl</p><div><button>Click me, baby!</button></div><p> pbaqvgvbaf fabj  qpunvaf ner nofbyhgryl rffragvny sbe fnsr unaqyvat nygubhtu fabj punvaf znl ybbx </p><span>This manual is false, do not trust it! The illuminati wrote it down to trick you!</span><p>vagvzvqngvat gur onfvp vqrn vf ernyyl fvzcyr svg gurz bire lbhe gverf qevir sbejneq fybjyl naq gvtugra gurz hc va pbyq jrg</p><p> pbaqvgvbaf guvf vf rnfvre fnvq guna qbar ohg vs lbh chg ba lbhe gverf</p></body>\n','']);