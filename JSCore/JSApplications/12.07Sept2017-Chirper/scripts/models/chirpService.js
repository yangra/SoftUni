let chirpService = (() => {
    function listAllChirpsByFollowers() {
        let subs = sessionStorage.getItem('subscriptions');
        const endpoint = `chirps?query={"author":{"$in": ${subs}}}&sort={"_kmd.ect": 1}`;

        return requester.get('appdata', endpoint, 'kinvey');
    }

    function deleteChirp(chirpId) {
        const endpoint = `chirps/${chirpId}`;

        return requester.remove('appdata', endpoint, 'kinvey');
    }

    function viewAllChirpsByUser(username) {
        //let username = sessionStorage.getItem('username');
        let endpoint = `chirps?query={"author":"${username}"}&sort={"_kmd.ect": 1}`;

        return requester.get('appdata', endpoint, 'kinvey');
    }

    function createChirp(text) {
        let author = sessionStorage.getItem('username');
        const endpoint = `chirps`;
        let chirpData = {author, text};

        return requester.post('appdata', endpoint, 'kinvey', JSON.stringify(chirpData));
    }
    async function countChirps(username) {
        // let username = sessionStorage.getItem('username');
        // let endpoint = `chirps?query={"author":"${username}"}`;
        //
        // requester.get('appdata', endpoint, 'kinvey');

        return (await viewAllChirpsByUser(username)).length;
    }

    async function countFollowing(username) {
        // if(username === sessionStorage.getItem('username')){
        //     return JSON.parse(sessionStorage.getItem('subscriptions')).length;
        // }

        let endpoint = `?query={"username":"${username}"}`;
        return ( await requester.get('user', endpoint, 'kinvey'))[0].subscriptions.length;
    }

    async function countFollowers(username) {
        //let username = sessionStorage.getItem('username');
        let endpoint = `?query={"subscriptions":"${username}"}`;

        return ( await requester.get('user', endpoint, 'kinvey')).length;
    }

    function listUsers() {

        return requester.get('user', '', 'kinvey');
    }

    function follow(usernameToFollow) {
        let userId = sessionStorage.getItem('userId');
        let endpoint = `${userId}`;
        let subscriptions = JSON.parse(sessionStorage.getItem('subscriptions'));
        subscriptions.push(usernameToFollow);
        sessionStorage.setItem('subscriptions', JSON.stringify(subscriptions));
        let userData = JSON.stringify({subscriptions});

        return requester.update('user', endpoint, 'kinvey', userData)
    }

    function unfollow(usernameToUnfollow) {
        let userId = sessionStorage.getItem('userId');
        let endpoint = `${userId}`;
        let subscriptions = JSON.parse(sessionStorage.getItem('subscriptions'));
        subscriptions = subscriptions.filter(s => s !== usernameToUnfollow);

        sessionStorage.setItem('subscriptions', JSON.stringify(subscriptions));
        let userData = JSON.stringify({subscriptions});

        return requester.update('user', endpoint, 'kinvey', userData)
    }


    return {
        listAllChirpsByFollowers,
        createChirp,
        deleteChirp,
        viewAllChirpsByUser,
        countChirps,
        countFollowing,
        countFollowers,
        listUsers,
        follow,
        unfollow,
    }
})()