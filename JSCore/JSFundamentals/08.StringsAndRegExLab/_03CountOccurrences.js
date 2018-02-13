function countOccurrences(str, text) {
    //let words = text.split('/\W+/').filter(w => w !== '');
    let counter = 0;
    while(true){
        let startIndex = text.indexOf(str);
        if(startIndex < 0){
            break;
        }
        counter++;
        text = text.substr(startIndex+1);
    }
    console.log(counter);
}

countOccurrences('the', 'The quick brown fox jumps over the lay dog.')
countOccurrences('ma', 'Marine mammal training is the training and caring for marine life such as, dolphins, killer whales, sea lions, walruses, and other marine mammals. It is also a duty of the trainer to do mental and physical exercises to keep the animal healthy and happy.');