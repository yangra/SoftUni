function attachEvents() {
    const URL = 'https://baas.kinvey.com/appdata/kid_HkvmClZcf/biggestCatches/';
    const USER = 'guest';
    const PASS = 'guest';
    const base64 = btoa(USER + ":" + PASS);
    const AUTH = 'Basic ' + base64;


    $('#aside').find('button.load').on('click', loadData);
    $('#aside').find('button.add').on('click', addCatch);

    function loadData() {
        $('#catches').empty();
        $.ajax({
            url: URL,
            headers: {'Authorization': AUTH},
            success: listAllCatches,
            error: handleError
        });

        function listAllCatches(res) {
            for (let obj of res) {
                $('#catches').append(catchElement(obj))
            }
        }
    }

    function catchElement(obj) {
        let element = $(`<div class="catch" data-id="${obj._id}">`)
            .append(catchFields(obj))
            .append(catchButton('update', 'Update', updateFisherman))
            .append(catchButton('delete', 'Delete', deleteFisherman));
        return element;
    }

    function catchFields(obj) {
        let fields = $(`<label>Angler</label>
            <input type="text" class="angler" value="${obj.angler}" />
            <label>Weight</label>
            <input type="number" class="weight" value="${obj.weight}" />
            <label>Species</label>
            <input type="text" class="species" value="${obj.species}" />
            <label>Location</label>
            <input type="text" class="location" value="${obj.location}" />
            <label>Bait</label>
            <input type="text" class="bait" value="${obj.bait}" />
            <label>Capture Time</label>
            <input type="text" class="captureTime" value="${obj.captureTime}" />`);
        return fields;
    }

    function catchButton(propClass, text, action) {
        let button = $(`<button class="${propClass}">${text}</button>`).on('click', (e) => action(e));
        return button;
    }

    function updateFisherman(e) {
        let currentCatch = $(e.target).parent();
        let updatedFisherman = {
            'angler': currentCatch.find('input.angler').val(),
            'weight': Number(currentCatch.find('input.weight').val()),
            'species': currentCatch.find('input.species').val(),
            'location': currentCatch.find('input.location').val(),
            'bait': currentCatch.find('input.bait').val(),
            'captureTime': Number(currentCatch.find('input.captureTime').val())
        };
        $.ajax({
            method: 'PUT',
            url: URL + currentCatch.attr('data-id'),
            headers: {
                'Authorization': AUTH,
                'Content-type': 'application/json'
            },
            data: JSON.stringify(updatedFisherman),
            success: updateView,
            error: handleError
        });

        function updateView(res) {
            currentCatch.empty();
            currentCatch.append(catchFields(res));
            currentCatch.append(catchButton('update', 'Update', updateFisherman))
                .append(catchButton('delete', 'Delete', deleteFisherman));
        }
    }

    function deleteFisherman(e) {
        let currentCatch = $(e.target).parent();
        $.ajax({
            method: 'DELETE',
            url: URL + currentCatch.attr('data-id'),
            headers: {
                'Authorization': AUTH,
                'Content-type':'application/json'
            },
            success: updateView,
            error: handleError
        });

        function updateView() {
            currentCatch.remove();
        }
    }

    function addCatch() {
        const addForm = $('#addForm');

        let newFisherman = {
            'angler': addForm.find('input.angler').val(),
            'weight': Number(addForm.find('input.weight').val()),
            'species': addForm.find('input.species').val(),
            'location': addForm.find('input.location').val(),
            'bait': addForm.find('input.bait').val(),
            'captureTime': Number(addForm.find('input.captureTime').val())
        };

        $.ajax({
            method: 'POST',
            url: URL,
            headers: {
                'Authorization': AUTH,
                'Content-type': 'application/json'
            },
            data: JSON.stringify(newFisherman),
            success: visualize,
            error: handleError
        });

        function visualize() {
            $('#catches').append(catchElement(newFisherman));
        }
    }

    function handleError() {
        $('#catches').text('Error');
    }
}