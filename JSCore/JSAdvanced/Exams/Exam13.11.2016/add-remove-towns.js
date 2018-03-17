function attachEvents() {
    let delBtn = $('#btnDelete');
    delBtn.on('click', deleteSelected);
    let addBtn = $('#btnAdd');
    addBtn.on('click', addTown);

    function deleteSelected() {
        let select = $('#towns');
        let selected = select.children().toArray().filter(e => $(e).is(':selected'));
        $(selected).remove();
    }

    function addTown() {
        let input = $('#newItem');
        let value = input.val()
        if(value ===''){
            return;
        }

        $('#towns').append($('<option>').text(value));
        input.val('');
    }
}