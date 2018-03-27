function getInfo() {
    const URL = 'https://judgetests.firebaseio.com/businfo/';
    const stopName = $('#stopName');
    const buses = $('#buses');
    stopName.text('');
    buses.text('');

    let stopId = $('#stopId').val();
    $.ajax({
        url: URL + stopId + '.json',
        success: loadData,
        error: getError
    });

    function loadData(res) {
        stopName.text(res.name);
        for (let key in res.buses) {
            buses.append($('<li>').text(`Bus ${key} arrives in ${res.buses[key]} minutes`))
        }
    }

    function getError() {
        stopName.text('Error');
    }
};