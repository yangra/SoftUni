function attachEvents() {
    $('#items > li ').on('click', function () {
        let element = $(this);
        if (!element.attr('data-selected')) {
            $(this).attr('data-selected', true);
            $(this).css('background-color', '#DDD');
        } else {
            $(this).removeAttr('data-selected');
            $(this).css('background-color', '');
        }
    });

    $('#showTownsButton').on('click', function () {
        let result = $('#items > li[data-selected]').toArray().map(li => li.textContent).join(', ');
        $('#selectedTowns').text(`Selcted towns: ${result}`);
    });

}
