function attachEvents() {
    const URL = 'https://baas.kinvey.com/appdata/kid_HkvmClZcf/';
    const USERNAME = 'guest';//change if needed
    const PASSWORD = 'guest';//change if needed
    const BASE64AUTH = btoa(USERNAME + ':' + PASSWORD);
    const AUTHHEADERS = {'Authorization': 'Basic ' + BASE64AUTH};


    let posts = {};

    $('#btnLoadPosts').on('click',loadPosts);
    $('#btnViewPost').on('click',loadComments);

    function loadPosts() {
        
        $.ajax({
            url: URL + 'posts',
            headers: AUTHHEADERS
        }).then(function (res) {
            $('#posts').empty();
            for (let post of res) {
                $('#posts').append($(`<option value="${post._id}">${post.title}</option>`));
                posts[post._id] = post.body;
            }
        }).catch(function (err) {
            console.log(err);
        })
    }

    function loadComments() {

        let postId = $('#posts').val();
        let postSelected = $('#posts').find('option:selected').text();
        $('#post-title').text(postSelected);
        $('#post-body').text(posts[postId]);

        $.ajax({
            url: URL + `comments/?query={"post_id":"${postId}"}`,
            headers: AUTHHEADERS
        }).then(function (res) {
            $('#post-comments').empty();
            for (let comment of res) {
                $('#post-comments').append($(`<li>${comment.text}</li>`))
            }
        }).catch(function (err) {
            console.log(err);
        })

    }
}