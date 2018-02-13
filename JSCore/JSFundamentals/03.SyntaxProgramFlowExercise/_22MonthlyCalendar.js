function calendar([day, month, year]) {
    let currentDate = new Date(year, month - 1, day);
    let leap = isLeap(year);
    let daysInPrevMonth = getNumberOfDaysInMonth(month - 1, leap);
    let daysInMonth = getNumberOfDaysInMonth(month, leap);
    let weekDayOfFirst = getDayOfFirst(currentDate.getDate(), currentDate.getDay());
    let weekDayOfLast = getDayOfLast(currentDate.getDate(), currentDate.getDay(), daysInMonth);

    console.log('<table>');
    console.log('<tr><th>Sun</th><th>Mon</th><th>Tue</th><th>Wed</th><th>Thu</th><th>Fri</th><th>Sat</th></tr>');
    let line = '<tr>';
    for( let count = 1; count <= daysInMonth;) {
        for (let i = 0; i <= 6; i++) {
            if (count > daysInMonth) {
                line += `<td class="next-month">${i - weekDayOfLast + 1}</td>`;
                continue;
            }
            if (i < weekDayOfFirst && count === 1) {
                line += `<td class="prev-month">${daysInPrevMonth - weekDayOfFirst + i + 1}</td>`;
            } else if (count < currentDate.getDate() || count > currentDate.getDate()) {
                line += `<td>${count}</td>`;
                count++;
            } else if (count === currentDate.getDate()) {
                line += `<td class="today">${currentDate.getDate()}</td>`;
                count++;
            }
        }
        line += '</tr>\n';
        if (count <= daysInMonth) {
            line += '<tr>';
        }
    }
    line += '</table>';
    console.log(line);

    function getDayOfLast(date, dayOfWeek, numberOfDaysInMonth) {
        for (let i = date; i <= numberOfDaysInMonth; i++) {
            dayOfWeek++;
            if (dayOfWeek === 7) {
                dayOfWeek = 0;
            }
        }
        return dayOfWeek;
    }

    function getDayOfFirst(date, dayOfWeek) {
        for (let i = --date; i >= 1; i--) {
            dayOfWeek--;
            if (dayOfWeek === -1) {
                dayOfWeek = 6;
            }
        }
        return dayOfWeek;
    }

    function isLeap(year) {
        if (year % 4 === 0 && year % 100 !== 0 || year % 400 === 0) {
            return true;
        }
    }

    function getNumberOfDaysInMonth(month, leap) {
        switch (month) {
            case 0:
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (leap) {
                    return 29;
                } else {
                    return 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 'error';
        }
    }
}

calendar([1, 1, 1900]);
calendar([7, 2, 2000]);
calendar([4, 9, 2016]);