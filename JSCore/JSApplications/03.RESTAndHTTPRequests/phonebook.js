function attachEvents() {
    const URL = 'https://phonebook-5ddbe.firebaseio.com/phonebook';
    const person = $('#person');
    const phone = $('#phone');

    $('#btnLoad').on('click', loadData);
    $('#btnCreate').on('click', postData);

    function loadData() {
        $('#phonebook').empty();
        $.ajax({
            method: 'GET',
            url: URL + '.json'
        }).then(handleSuccess)
            .catch(handleError);

        function handleSuccess(res) {
            for (let key in res) {
                if (res[key] !== null) {
                    appendListItem(res[key].person, res[key].phone, key);
                }
            }
        }
    }

    function postData() {
        let name = person.val();
        let phoneVal = phone.val();
        let postObj = JSON.stringify({'person': name, 'phone': phoneVal});
        $.ajax({
            method: 'POST',
            url: URL + '.json',
            data: postObj,
            success: appendElement,
            error: handleError
        });

        function appendElement(res) {
            person.val('');
            phone.val('');
            appendListItem(name, phoneVal, res.person);
        }
    }

    function appendListItem(name, phone, id) {
        let li = $(`<li>${name}: ${phone} </li>`)
            .append($('<button>[Delete]</button>')
                .on('click', function () {
                    $.ajax({
                        method: 'DELETE',
                        url: URL + '/' + id + '.json',
                        success: () => $(li).remove(),
                        error: handleError
                    })
                }));
        $('#phonebook').append(li);
    }

    function handleError(err) {
        console.log(err);
    }
}