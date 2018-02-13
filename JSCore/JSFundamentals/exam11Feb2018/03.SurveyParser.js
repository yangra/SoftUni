function solve(text) {
    let surveyPattern = /(?:(?:\s|.)*?)<svg>((?:\s|.)*?)<\/svg>(?:(?:\s|.)*?)/g;
    let sectionsPattern = /(?:(?:\s|.)*?)<cat>((?:\s|.)*?)<\/cat>\s*<cat>((?:\s|.)*?)<\/cat>(?:(?:\s|.)*?)/g;
    let validLabelPatern = /(?:(?:\s|.)*?)<text>(?:(?:\s|.)*?)(\[((?:.|\s)*?)\])(?:(?:\s|.)*?)<\/text>(?:(?:\s|.)*?)/g;
    let secondSectionPattern = /(?:(?:\s|.)*?)<g>((?:\s|.)*?)<\/g>(?:(?:\s|.)*?)/g;
    let valuesPattern = /(?:(?:\s|.)*?)<val>([1-9]0?)<\/val>([0-9]*)(?:(?:\s|.)*?)/g

    let label;
    let valuesMap = new Map();

    let surveyExists = surveyPattern.exec(text);
    if (surveyExists) {
        let twoSectionsExist = sectionsPattern.exec(surveyExists[1]);
        if (twoSectionsExist) {
            let getLabel = validLabelPatern.exec(twoSectionsExist[1]);
            if (getLabel) {
                label = getLabel[2];
            } else {
                console.log('Invalid format');
                return;
            }
            let secondSectionValues = secondSectionPattern.exec(twoSectionsExist[2]);
            while (secondSectionValues) {
                let values = valuesPattern.exec(secondSectionValues[1]);
                if (values && Number(values[1]) <= 10) {
                    if (valuesMap.has(Number(values[1]))) {
                        valuesMap.set(Number(values[1]), valuesMap.get(Number(values[1])) + Number(values[2]));
                    } else {
                        valuesMap.set(Number(values[1]), Number(values[2]));
                    }
                }
                valuesPattern.lastIndex = 0;
                secondSectionValues = secondSectionPattern.exec(twoSectionsExist[2]);
            }
        } else {
            console.log('Invalid format');
            return;
        }
    } else {
        console.log('No survey found');
        return;
    }

    let count = 0;
    let sum = 0;
    for (let [key, value] of valuesMap) {
        sum += key * value;
        count += value;
    }
    let avg = Math.round((sum / count) * 100) / 100;

    console.log(`${label}: ${avg}`);
}

solve('<p>Some random text</p><svg><cat><text>How do you rate our food? [Food - General]</text></cat><cat><g><val>1</val>0</g><g><val>2</val>1</g><g><val>3</val>3</g><g><val>4</val>10</g><g><val>5</val>7</g></cat></svg><p>Some more random text</p>\n');
solve('<p>How do you suggest we improve our service?</p><p>More tacos.</p><p>It\'s great,\n' +
    'don\'t mess with it!</p><p>I\'d like to have the option for delivery</p>');
solve('<svg><cat><text>How do you rate the special menu? [Food - Special]</text></cat>\n' +
    '<cat><g><val>1</val>5</g><g><val>5</val>13</g><g><val>10</val>22</g></cat></svg>');
solve('<svg><cat><text>Which is your favourite meal from our\n' +
    'selection?</text></cat><cat><g><val>Fish</val>15</g><g><val>Prawns</val>31</g><g><val>Crab Langoon</val>12</g><g><val>Calamari</val>17</g></cat></svg>\n')