function tableBuilder(selector) {
    let container = $(selector);
    return {
        createTable: function(columnNames){
            container.empty();
            let table = $('<table>');
            let tableHeader = $('<tr>');
            for (let columnName of columnNames) {
                $('<th>').text(columnName).appendTo(tableHeader);
            }
            $('<th>').text('Action').appendTo(tableHeader);
            table.append(tableHeader);
            container.append(table);
        },

        fillData: function(dataRows){

            for (let dataRow of dataRows) {
                let row = $('<tr>');
                for (let data of dataRow) {
                    $('<td>').text(data).appendTo(row);
                }
                let btn = $('<button>').text('Delete');
                btn.on('click',(e)=>{
                    let row = $(e.target).parent().parent();
                    row.remove();
                });
                btn.appendTo($('<td>').appendTo(row));
                container.find('table').append(row);
            }

        }
    }
}