function calendar(arr) {
    let [day, month, year] = arr;
    month -= 1;

    let todayDate = new Date(year, month, day);
    let firstCurrentMonth = new Date(year, month);
    let lastCurrentMonth = new Date(year, month + 1, 0);

    let monthNames = ["January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"];
    let table = $('<table>');
    let caption = $('<caption>').text(`${monthNames[todayDate.getMonth()]} ${year}`);
    let tableBody = $('<tbody>');
    let tableHeader = $('<tr>');

    tableHeader.append($('<th>').text('Mon'))
        .append($('<th>').text('Tue'))
        .append($('<th>').text('Wed'))
        .append($('<th>').text('Thu'))
        .append($('<th>').text('Fri'))
        .append($('<th>').text('Sat'))
        .append($('<th>').text('Sun'));

    table.append(caption);
    tableBody.append(tableHeader);
    let currentDay = 1;

    //add empty fields in the beginning of month
    let tr = $('<tr>');
    let additionalFields = firstCurrentMonth.getDay()===0?6:firstCurrentMonth.getDay()-1;
    for (let i = 0; i < additionalFields; i++) {
        tr.append($('<td>'));
    }

    //add calendar days to the table row
    while (currentDay <= lastCurrentMonth.getDate()) {
        let currentDate = new Date(year, month, currentDay);
        if (currentDate.getDay() === 1) {
            tr = $('<tr>');
        }

        if (currentDay === day) {
            tr.append($('<td>').addClass('today').text(`${currentDay}`));
        } else {
            tr.append($('<td>').text(`${currentDay}`));
        }

        if (currentDate.getDay() === 0) {
            tableBody.append(tr);
        }

        currentDay++;
    }

    //add empty fields in the end of month
    additionalFields = lastCurrentMonth.getDay()===0?0:7-lastCurrentMonth.getDay();
    for (let i = 0; i < additionalFields; i++) {
        tr.append($('<td>'));
    }

    tableBody.append(tr);
    table.append(tableBody);
    $('#content').append(table);
}