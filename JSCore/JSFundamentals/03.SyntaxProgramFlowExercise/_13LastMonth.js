function  lastMonthsDays(date) {
    let [day, month, year] = date;

    let newDate = new Date(year, month-1, 0);
    let daysCount = newDate.getDate();

    return daysCount;
}