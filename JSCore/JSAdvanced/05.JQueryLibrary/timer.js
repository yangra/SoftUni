function timer() {
    let seconds = $('#seconds');
    let minutes = $('#minutes');
    let hours = $('#hours');

    let startBtn = $('#start-timer');
    let stopBtn = $('#stop-timer');
    startBtn.on('click', start);
    stopBtn.on('click', stop);

    let interval;

    function start() {
        startBtn.attr('disabled', true);
        stopBtn.attr('disabled', false);
        seconds.text('00');
        minutes.text('00');
        hours.text('00');
        interval = setInterval(time, 1000);

        function time() {
            if (Number(seconds.text()) < 59) {
                seconds.text(addFrontZero(Number(seconds.text()) + 1));
            } else {
                if (Number(minutes.text()) < 59) {
                    seconds.text('00');
                    minutes.text(addFrontZero(Number(minutes.text()) + 1));
                } else {
                    if (Number(hours.text()) < 23) {
                        seconds.text('00');
                        minutes.text('00');
                        hours.text(addFrontZero(Number(hours.text()) + 1));
                    } else {
                        seconds.text('00');
                        minutes.text('00');
                        hours.text('00');
                    }
                }
            }
        }

        function addFrontZero(number) {
            if (number < 10) {
                return '0' + number;
            } else {
                return number;
            }
        }
    }

    function stop() {
        stopBtn.attr('disabled', true);
        startBtn.attr('disabled', false);
        clearInterval(interval);
    }
}