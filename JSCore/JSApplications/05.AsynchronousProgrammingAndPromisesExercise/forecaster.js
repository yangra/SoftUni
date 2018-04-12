function attachEvents() {

    let divForecast = $('#forecast');
    let conditions = new Map();
    conditions.set('Sunny', '&#x2600;');
    conditions.set('Partly sunny', '&#x26C5;');
    conditions.set('Overcast', '&#x2601;');
    conditions.set('Rain', '&#x2614;');
    conditions.set('Degrees', '&#176;');

    $('#submit').on('click', getData);

    function getData() {
        $.get("https://judgetests.firebaseio.com/locations.json")
            .then(getCodes)
            .catch(catchError);
    }


    function getCodes(res) {
        let userEntry = $('#location').val();
        divForecast.attr('style', 'display:block');
        let found;
        for (let obj of res) {
            if (userEntry === obj.name) {
                $.get(`https://judgetests.firebaseio.com/forecast/today/${obj.code}.json`)
                    .then(getInfo)
                    .catch(catchError);
                $.get(`https://judgetests.firebaseio.com/forecast/upcoming/${obj.code}.json`)
                    .then(get3DayInfo)
                    .catch(catchError);
                found = true;
                divForecast.empty();
            }
        }

        if (!found) {
            catchError();
        }
    }

    function createWeatherElement(res) {
        let element =
            $(`<span class="condition">`)
                .append($(`<span class="forecast-data">${res.name}</span>`))
                .append($(`<span class="forecast-data">${res.forecast.low}${conditions.get('Degrees')}/${res.forecast.high}${conditions.get('Degrees')}</span>`))
                .append($(`<span class="forecast-data">${res.forecast.condition}</span>`));
        return element;
    }

    function createUpcomingWeatherElement(obj) {
        let element = $(`<span class="upcoming">`)
            .append($(`<span class="symbol">${conditions.get(obj.condition)}</span>`))
            .append($(`<span class="forecast-data">${obj.low}${conditions.get('Degrees')}/${obj.high}${conditions.get('Degrees')}</span>`))
            .append($(`<span class="forecast-data">${obj.condition}</span>`));
        return element;
    }

    function getInfo(res) {
        divForecast.append('<div id="current"><div class="label">Current conditions</div></div>');
        $('#current').append($(`<span class="condition symbol">${conditions.get(res.forecast.condition)}</span>`))
            .append(createWeatherElement(res));
    }


    function get3DayInfo(res) {
        divForecast.append('<div id="upcoming"><div class="label">Three-day forecast</div></div>');
        for (let obj of res.forecast) {
            $('#upcoming').append(createUpcomingWeatherElement(obj));
        }
    }

    function catchError() {
        divForecast.text('Error');
    }

}