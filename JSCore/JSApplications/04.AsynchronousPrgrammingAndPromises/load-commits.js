function loadCommits() {
    let username = $('#username');
    let repo = $('#repo');
    let commits = $('#commits');
    let repoName = repo.val();
    let userName = username.val();
    $.ajax({
        url: `https://api.github.com/repos/${userName}/${repoName}/commits`
    }).then(function (res) {
        commits.empty();
        for (let obj of res) {
            commits.append(`<li>${obj.commit.author.name}: ${obj.commit.message}`);
        }
    }).catch(function (err) {
        commits.empty();
        commits.append($(`<li>Error: ${err.status} (${err.statusText})</li>`));
    })
}
