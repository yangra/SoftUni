function extractUsernames(arr) {
    let result = [];
    for (let i = 0; i < arr.length; i++) {
        let tokens = arr[i].split('@')
        let domain = tokens[1].split('.');
        let username = tokens[0].split('');
        username.push('.');
        for (let str of domain) {
            username.push(str[0]);
        }
        username = username.join('');
        result.push(username);
    }

    console.log(result.join(', '));
}

extractUsernames(['peshoo@gmail.com', 'todor_43@mail.dir.bg', 'foo@bar.com'])