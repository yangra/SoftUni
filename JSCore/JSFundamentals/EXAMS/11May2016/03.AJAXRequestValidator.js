function validate(arr) {
    let methodPattern = /^Method: (GET|PUT|DELETE|POST)$/;
    let authPattern = /^Credentials: (Basic|Bearer) ([a-zA-Z0-9]+)$/;
    let contentPattern = /^Content: [a-zA-Z0-9.]+$/;
    let hashPattern = /([0-9])([a-zA-Z])/g;

    arr = arr.filter(s => s !== '');
    let hash = arr[arr.length - 1];


    for (let i = 0; i < arr.length - 1; i += 3) {
        if (arr[i].match(methodPattern)) {
            let method = methodPattern.exec(arr[i])[1];
            if (arr[i + 1].match(authPattern) && arr[i + 2].match(contentPattern)) {
                let token = authPattern.exec(arr[i + 1]);
                if (method === 'GET' || method !== 'GET' && token[1] === 'Bearer') {
                    if (checkHash(token[2])) {
                        console.log(`Response-Method:${method}&Code:200&Header:${token[2]}`);
                    } else {
                        console.log(`Response-Method:${method}&Code:403`);
                    }
                } else {
                    console.log(`Response-Method:${method}&Code:401`);
                }
            } else {
                console.log('Response-Code:400');
            }
        } else {
            console.log('Response-Code:400');
        }


    }

    function checkHash(token) {
        let match = hashPattern.exec(hash);
        while (match) {
            let times = Number(match[1]);
            let letter = match[2];
            let counter = 0;
            for (let symbol of token) {
                if (letter === symbol) {
                    counter++;
                }
            }
            if (counter === times) {
                hashPattern.lastIndex = 0;
                return true;
            }
            match = hashPattern.exec(hash);
        }

        return false;
    }
}

validate(['Method: GET',
    'Credentials: Bearer asd918721jsdbhjslkfqwkqiuwjoxXJIdahefJAB',
    'Content: users.asd.1782452.278asd',
    'Method: POST',
    'Credentials: Basic 028591u3jtndkgwndsdkfjwelfqkjwporjqebhas',
    'Content: Johnathan',
    '2q']);

validate(['Method: PUT',
    'Credentials: Bearer as9133jsdbhjslkfqwkqiuwjoxXJIdahefJAB',
    'Content: users.asd/1782452$278///**asd123',
    'Method: POST',
    'Credentials: Bearer 028591u3jtndkgwndskfjwelfqkjwporjqebhas',
    'Content: Johnathan',
    'Method: DELETE',
    'Credentials: Bearer 05366u3jtndkgwndssfsfgeryerrrrrryjihvx',
    'Content: This.is.a.sample.content',
    '2e5g'])