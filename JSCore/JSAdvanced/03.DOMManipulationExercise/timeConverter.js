function attachEventsListeners() {

    let daysBtn = document.getElementById('daysBtn');
    let hoursBtn = document.getElementById('hoursBtn');
    let minutesBtn = document.getElementById('minutesBtn');
    let secondsBtn = document.getElementById('secondsBtn');
    daysBtn.addEventListener('click', calcTime);
    hoursBtn.addEventListener('click', calcTime);
    minutesBtn.addEventListener('click', calcTime);
    secondsBtn.addEventListener('click', calcTime);

    function calcTime(event) {
        let days = document.getElementById('days');
        let hours = document.getElementById('hours');
        let minutes = document.getElementById('minutes');
        let seconds = document.getElementById('seconds');
console.log(event);
        let timeInSeconds;
        switch (event.target.getAttribute('id')) {
            case 'daysBtn':
                timeInSeconds = Number(days.value) * 24 * 60 * 60;
                break;
            case 'hoursBtn':
                timeInSeconds = Number(hours.value) * 60 * 60;
                break;
            case 'minutesBtn':
                timeInSeconds = Number(minutes.value) * 60;
                break;
            case 'secondsBtn':
                timeInSeconds = Number(seconds.value);
                break;
        }

        days.value = timeInSeconds / 24 / 60 / 60;
        hours.value = timeInSeconds / 60 / 60;
        minutes.value= timeInSeconds / 60;
        seconds.value = timeInSeconds;
    }
}