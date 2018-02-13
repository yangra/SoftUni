function decodeMessage(arr) {
    let specKey = arr.shift();
    let regex = new RegExp(`(^| )(${specKey})((?: )+)([!%$#A-Z]{8,})( |\\.|,|$)`, 'gi');
    let lowerCaseRegex = /[a-z]/;
    let result = [];
    for (let str of arr) {
        let match = regex.exec(str);
        if (match === null) {
            result.push(str);
        }
        while (match) {
            if (match[4].match(lowerCaseRegex) !== null) {
                match = regex.exec(str);
                if (match === null) {
                    result.push(str);
                }
                continue;
            }
            let changed = '';
            for (let symbol of match[4].toLowerCase()) {
                switch (symbol) {
                    case '!': changed += '1'; break;
                    case '%': changed += '2'; break;
                    case '#': changed += '3'; break;
                    case '$': changed += '4'; break;
                    default: changed += symbol; break;
                }
            }
            let replacement = match[1] + match[2] + match[3] + changed + match[5];
            str = str.substring(0, match['index']) + replacement + str.substring(match['index'] + replacement.length, str.length);
            match = regex.exec(str);
            if (match === null) {
                result.push(str);
            }
        }
    }

    for (let str of result) {
        console.log(str);
    }
}

// decodeMessage(['specialKey',
// 'In this text the specialKey HELLOWORLD! is correct, but',
// 'the following specialKey $HelloWorl#d and spEcIaLKEy HOLLOWORLD1 are not, while',
// 'SpeCIaLkeY   SOM%%ETH$IN and SPECIALKEY ##$$##$$ are!']);

// decodeMessage(['enCode',
// 'Some messages are just not encoded what can you do?',
// 'RE - ENCODE THEMNOW! - he said.',
// 'Damn encode, ITSALLHETHINKSABOUT, eNcoDe BULL$#!%.'])

decodeMessage(['tricky',
    'And now the tricky tests',
    'Tricky CAREFULL!#$%; with what you decode Tricky CAREFULL!#$%',
    'Tricky HERECOMESDASH- with what you decode Tricky HERECOMESDASH -',
    'Try again stricky NOTTHEFIRSTONE  tricky NOTTHEFIRSTONE',
    'Be very carefull now trICkY plainwrong, trICkY PLAINWRONG',
    'next challenge (tRickY SOME$WORDS) tRickY SOME$WORDS',
    'It\'s tricky TOUSETHECORRECTREPLACE? tricky TOUSETHECORRECTREPLACE ,',
    'now with commas triCky RAND!$OM%$#TE!#XT, triCky RAND!$OM%$#TE!#XT.',
    'DON\'T match this plz TRICKY | TEXT#TEXT. TRICKY  TEXT#TEXT.',
    'Try with commas -triCkY COMMAHERE, triCkY COMMAHERE, wow']);