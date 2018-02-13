function dayOfWeek(day) {
    let days = ['monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday', 'sunday'];
    let index = days.indexOf(day.toLowerCase());
    return index > -1 ? index + 1 : 'error';
}

console.log(dayOfWeek('Monday'));