function sort(colIndex, descending) {

    let rowData = $('#products').find('tr').toArray();
    rowData.shift();
    let debug = '';
    if (colIndex === 0) {
        if (!descending) {
            rowData.sort((a, b) => $($(a).children()[0]).text().localeCompare($($(b).children()[0]).text()));
        } else {
            rowData.sort((a, b) => $($(b).children()[0]).text().localeCompare($($(a).children()[0]).text()));
        }
    } else {
        if (!descending) {
            rowData.sort((a, b) => $($(a).children()[1]).text() - $($(b).children()[1]).text());
        } else {
            rowData.sort((a, b) => $($(b).children()[1]).text() - $($(a).children()[1]).text());
        }
    }

    $('#products').append(rowData);
}