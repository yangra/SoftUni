function solve() {

    let URL  = 'https://judgetests.firebaseio.com/schedule/';
    let firstStopId = 'depot';
    let nextStopId;
    let nextStopName;
    let infoTag = $('#info').find('span.info');

    function depart() {
        let currentStopId;
        if(nextStopId === undefined){
            currentStopId = firstStopId;
        }else{
            currentStopId = nextStopId;
        }

        $('#depart').attr('disabled', true);
        $('#arrive').attr('disabled', false);
        $.get(`https://judgetests.firebaseio.com/schedule/${currentStopId}.json`)
            .then(updateState)
            .catch(handleError);

        function updateState(res) {
            nextStopId = res.next;
            nextStopName = res.name;
            infoTag.text('Next stop ' + nextStopName)
        }

        function handleError() {
            infoTag.text('Error');
        }
    }

    function arrive() {
        $('#depart').attr('disabled', false);
        $('#arrive').attr('disabled', true);

        infoTag.text('Arriving at ' + nextStopName)

    }

    return {
        depart,
        arrive
    };
}

let result = solve();