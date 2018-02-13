function XMLFormat(data) {
    templateStart();
    for (let i = 0; i < data.length - 1; i += 2) {
        questionXML(data[i]);
        answerXML(data[i + 1]);
    }
    templateEnd();


    function templateStart() {
        console.log('<?xml version="1.0" encoding="UTF-8"?>');
        console.log('<quiz>');
    }

    function questionXML(question) {
        console.log('  <question>');
        console.log('    ' + question);
        console.log('  </question>');
    }

    function answerXML(answer) {
        console.log('  <answer>');
        console.log('    ' + answer);
        console.log('  </answer>');
    }

    function templateEnd() {
        console.log('</quiz>');
    }
}

XMLFormat(['Dry ice is a frozen form of which gas?',
'Carbon Dioxide',
'What is the brightest star in the night sky?',
'Sirius']);