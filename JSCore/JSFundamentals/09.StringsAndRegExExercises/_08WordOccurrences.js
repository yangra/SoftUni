function wordCount(text, word) {
    let regex = new RegExp(`\\b${word}\\b`, 'gi');
    let counter = 0;
    let match = regex.exec(text);

    while (match){
        counter++;
        match = regex.exec(text);
    }

    console.log(counter);
}

wordCount('The waterfall was so high, that the child couldn’t see its peak.', 'the');
wordCount('How do you plan on achieving that? How? How can you even think of that?', 'how');
wordCount('There was one. Therefore I bought it. I wouldn’t buy it otherwise.', 'there');