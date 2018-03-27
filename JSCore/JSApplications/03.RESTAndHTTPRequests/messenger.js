function attachEvents() {
    const URL = 'https://messenger-2312a.firebaseio.com/';

    $('#submit').on('click', submitNewMessage);
    $('#refresh').on('click', reloadMessages);


    function submitNewMessage() {

        let newMessage = {
            author: $('#author').val(),
            content: $('#content').val(),
            timestamp: Date.now()
        };
        $.ajax({
            method: 'POST',
            url: URL + '.json',
            headers: {'Content-type': 'application/json'},
            data: JSON.stringify(newMessage),
            success: reloadMessages,
            error: handleError
        })
    }

    function reloadMessages() {
        $('#author').val('');
        $('#content').val('');
        $.ajax({
            method: 'GET',
            url: URL + '.json',
            success: listAllMessages,
            error: handleError
        });
        
        function listAllMessages(res) {
            let text = '';
            for (let key in res) {
               text += res[key].author +': ' + res[key].content + '\n';
            }
            $('#messages').text(text);
        }
    }
    
    function handleError() {
        $('#messages').text('Error');
    }
}