function createBook(selector, title, author, ISBN) {
    let book = (function bookGenerator() {
        let id = 0;
        return function (selector, title, author, ISBN) {
            let div = $('<div>').attr('id', 'book' + ++id);
            let titleP = $('<p>').addClass('title').text(title);
            let authorP = $('<p>').addClass('author').text(author);
            let isbnP = $('<p>').addClass('isbn').text(ISBN);
            let selectBtn = $('<button>').text('Select');
            let deselectBtn = $('<button>').text('Deselect');

            selectBtn.on('click', ()=>{
                div.css('border', '2px solid blue');
                selectBtn.attr('disabled', true);
                deselectBtn.attr('disabled', false);
            });

            deselectBtn.on('click', ()=>{
                div.css('border', '');
                selectBtn.attr('disabled', false);
                deselectBtn.attr('disabled', true);
            });

            div.append(titleP).append(authorP).append(isbnP).append(selectBtn).append(deselectBtn);
            div.appendTo($(selector));
        }
    }());

    book(selector, title, author, ISBN);
}