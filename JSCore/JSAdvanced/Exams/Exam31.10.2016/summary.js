function summary(selector){
    let btn = $(selector);
    btn.on('click',summarize);

    function summarize() {
        let content = $('#content');
        let contentCollection = content.find('strong');
        let resultText = '';
        contentCollection.each((i,s)=> resultText+=$(s).text());
        let parent = content.parent();
        let resultDiv = $('<div>').attr('id','summary');
        let header = $('<h2>Summary</h2>');
        let sumText = $('<p>').text(resultText);
        resultDiv.append(header).append(sumText);
        parent.append(resultDiv);
    }
}