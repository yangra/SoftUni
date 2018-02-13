function composeTag(input) {
    let [fileLocation, alternateText] = input;

    console.log(`<img src="${fileLocation}" alt="${alternateText}">`);
}