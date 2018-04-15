let auth = (() => {
    function saveSession(userInfo) {
        sessionStorage.setItem('authToken', userInfo._kmd.authtoken);
        sessionStorage.setItem('userId', userInfo._id);
        sessionStorage.setItem('username', userInfo.username);
        sessionStorage.setItem('subscriptions', JSON.stringify(userInfo.subscriptions))
    }

    function isAuth() {
        return sessionStorage.getItem('authToken') !== null;
    }

    // user/login
    function login(username, password) {
        let userData = JSON.stringify({
            username,
            password
        });

        return requester.post('user', 'login', 'basic', userData);
    }

    // user/register
    function register(username, password, subscriptions) {
        let userData = JSON.stringify({
            username,
            password,
            subscriptions,
        });

        return requester.post('user', '', 'basic', userData);
    }

    // user/logout
    function logout() {
        let logoutData = {
            authToken: sessionStorage.getItem('authToken')
        };

        return requester.post('user', '_logout', 'kinvey');
    }

    function handleError(response) {
        let errorMsg = JSON.stringify(response);
        if (response.readyState === 0)
            errorMsg = "Cannot connect due to network error.";
        if (response.responseJSON && response.responseJSON.description)
            errorMsg = response.responseJSON.description;
        showError(errorMsg)
    }

    function showInfo(message) {
        let infoBox = $('#infoBox');
        infoBox.html('<span>'+ message+'</span>');
        infoBox.show();
        setTimeout(() => infoBox.fadeOut(), 3000);
    }

    function showError(message) {
        let errorBox = $('#errorBox');
        errorBox.html('<span>'+ message+'</span>');
        errorBox.show();
        setTimeout(() => errorBox.fadeOut(), 3000);
    }

    return {
        login,
        register,
        logout,
        saveSession,
        isAuth,
        showInfo,
        showError,
        handleError
    }
})()