function domSearch(selector, isCaseSensitive) {
    let generateForm = (function formGenerator() {
        return function (selector, isCaseSensitive) {
            let addSection = $('<div>').addClass('add-controls');
            let addLabel = $('<label>').attr('for', 'add-field').text('Enter text:');
            let addInput = $('<input>').attr('id', 'add-field').attr('type', 'text');
            let addBtn = $('<a>').addClass('button').text('Add');
            addSection.append(addLabel).append(addInput).append(addBtn);

            let searchSection = $('<div>').addClass('search-controls');
            let searchLabel = $('<label>').attr('for', 'search-field').text('Search:');
            let searchInput = $('<input>').attr('id', 'search-field').attr('type', 'text');
            searchInput.on('input', searchItems);
            searchSection.append(searchLabel).append(searchInput);

            let resultSection = $('<div>').addClass('result-controls');
            let resultList = $('<ul>').addClass('items-list');
            resultSection.append(resultList);

            addBtn.on('click', () => {

                function deleteItem(event) {
                    $(event.target).parent().remove();
                }

                let deleteBtn = $('<a>').addClass('button').text('X');
                let item = $('<li>').addClass('list-item')
                    .html('<strong>' + addInput.val() + '</strong>');

                item.prepend(deleteBtn.on('click', deleteItem));
                resultList.append(item);
                addInput.val('');
            });

            function searchItems() {
                let caseSensitivePattern = new RegExp(`${searchInput.val()}.*`);
                let caseInsensitivePattern = new RegExp(`${searchInput.val()}.*`, 'i');


                $(' .list-item strong').each((i, e) => {
                    let element = $(e);
                    let pattern = isCaseSensitive ? caseSensitivePattern : caseInsensitivePattern;
                    if (!pattern.test(element.text())) {
                        element.parent().css('display', 'none');
                    } else {
                        element.parent().css('display', 'block');
                    }
                });
            }

            $(selector).append(addSection).append(searchSection).append(resultSection);
        }
    }());

    generateForm(selector, isCaseSensitive);
}

