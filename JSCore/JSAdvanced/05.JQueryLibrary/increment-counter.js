function increment(str) {
    let parent = $(str);
    let fragment = $(document.createDocumentFragment());
    let textArea = $('<textarea>').addClass('counter').val(0).attr('disabled', true);
    let incBtn = $('<button>').addClass('btn').attr('id', 'incrementBtn').text('Increment');
    let addBtn = $('<button>').addClass('btn').attr('id', 'addBtn').text('Add');
    let unordered = $('<ul>').addClass('results');
    fragment.append(textArea).append(incBtn).append(addBtn).append(unordered);
    fragment.appendTo(parent);

    incBtn.on('click', incValue);
    addBtn.on('click', addLi);

    function incValue() {
        textArea.val(Number(textArea.val()) + 1);
    }

    function addLi() {
        let li = $('<li>').text(textArea.val());
        li.appendTo(unordered);
    }
}