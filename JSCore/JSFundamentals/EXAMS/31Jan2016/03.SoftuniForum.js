function hyperUsernames(arr) {
    let banList = arr.pop().split(' ');
    let text = arr.join('\n');

    let codePattern = /<code>[\s\S]+?<\/code>/g;
    let codeBlocks = [];
    let matchingCode;
    while (matchingCode = codePattern.exec(text)) {
        let codeBlock = matchingCode[0];
        let codeReplacer = new Array(codeBlock.length).join('#');
        text = text.replace(codeBlock, codeReplacer);
        codeBlocks.push({
            original: codeBlock,
            replacedWith: codeReplacer
        });
    }

    banList.forEach(function (entry) {
        let censoredUserPattern = new RegExp('(#\\b' + entry + ')\\b', 'g');
        let match;
        while (match = censoredUserPattern.exec(text)) {
            let censoredName = match[1];
            let replacer = new Array(censoredName.length).join('*');
            text = text.replace(censoredName, replacer);
        }
    });

    let validUserPattern = /#(\b[a-zA-Z][\w\-]+[a-zA-Z0-9]\b)/g;
    let linkOpeningTag = '<a href="/users/profile/show/';
    let linkClosingTag = '</a>';
    text = text.replace(validUserPattern, linkOpeningTag + '$1">$1' + linkClosingTag);

    codeBlocks.forEach(function (codeBlock) {
        text = text.replace(codeBlock.replacedWith, codeBlock.original);
    });

    console.log(text);
}

hyperUsernames(['#RoYaL: I\'m not sure what you mean,',
    'but I am confident that I\'ve written',
    'everything correctly. Ask #iordan_93',
    'and #pesho if you don\'t believe me',
    '<code>',
    '#trying to print stuff',
    'print("yoo")',
    '</code>',
    'pesho gosho']);
