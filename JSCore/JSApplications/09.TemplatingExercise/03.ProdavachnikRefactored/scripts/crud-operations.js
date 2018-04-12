const BASE_URL = 'https://baas.kinvey.com/';
const APP_KEY = 'kid_HyW7Un1sf';
const APP_SECRET = '816a03097370433bb01b2a73a802cc82';
const AUTH_HEADERS = {'Authorization': "Basic " + btoa(APP_KEY + ":" + APP_SECRET)};
const ADS_PER_PAGE = 10;

function loginUser() {
    let username = $('#formLogin input[name=username]').val();
    let password = $('#formLogin input[name=passwd]').val();

    $.ajax({
        method: 'POST',
        url: BASE_URL + 'user/' + APP_KEY + '/login',
        headers: AUTH_HEADERS,
        data: {username, password}
    }).then(function (res) {
        signInUser(res, 'Login successful.');
    }).catch(handleAjaxError)
}

function registerUser() {
    let username = $('#formRegister input[name=username]').val();
    let password = $('#formRegister input[name=passwd]').val();

    $.ajax({
        method: 'POST',
        url: BASE_URL + 'user/' + APP_KEY + '/',
        headers: AUTH_HEADERS,
        data: {username, password}
    }).then(function (res) {
        signInUser(res, 'Registration successful.');
    }).catch(handleAjaxError)
}

function listAds() {
    $.ajax({
        url: BASE_URL + 'appdata/' + APP_KEY + '/ads',
        headers: {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')}
    }).then(function (res) {
        res = res.map(e=>{
            if(e._acl.creator === sessionStorage.getItem('userId')){
                e['isAuthor'] = true;
            }else {
                e['isAuthor'] = false;
            }
            return e;
        }).reverse();
        showAllAds(res);
    }).catch(handleAjaxError);
}

function createAd() {
    let title = $('#formCreateAd input[name=title]').val();
    let description = $('#formCreateAd textarea[name=description]').val();
    let datePublished = $('#formCreateAd input[name=datePublished]').val();
    let price = Number($('#formCreateAd input[name=price]').val()).toFixed(2);
    let imagePath = $('#formCreateAd input[name=image]').val();
    let publisher = sessionStorage.getItem('username');
    $.ajax({
        method: 'POST',
        headers: {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')},
        data: {publisher, title, description, datePublished, price, imagePath},
        url: BASE_URL + 'appdata/' + APP_KEY + '/ads'
    }).then(function (res) {
        listAds();
        showInfo('Add created');
    }).catch(handleAjaxError);
}

function deleteAd(ad) {
    $.ajax(({
        method: 'DELETE',
        url: BASE_URL + 'appdata/' + APP_KEY + '/ads/' + ad._id,
        headers: {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')}
    })).then(function () {
        listAds();
        showInfo('Ad deleted.');
    }).catch(handleAjaxError);
}

function loadAdForEdit(ad) {
    showEditAdView(ad);
    $('#formEditAd input[name=id]').val(ad._id);
    $('#formEditAd input[name=publisher]').val(ad._acl.creator);
    $('#formEditAd input[name=title]').val(ad.title);
    $('#formEditAd textarea[name=description]').val(ad.description);
    $('#formEditAd input[name=datePublished]').val(ad.datePublished);
    $('#formEditAd input[name=price]').val(ad.price);
}

function editAd() {
    let adId = $('#formEditAd input[name=id]').val();
    let publisher = sessionStorage.getItem('username');
    let title = $('#formEditAd input[name=title]').val();
    let description = $('#formEditAd textarea[name=description]').val();
    let datePublished = $('#formEditAd input[name=datePublished]').val();
    let price = Number($('#formEditAd input[name=price]').val()).toFixed(2);
    let imagePath = $('#formEditAd input[name=image]').val();
    $.ajax({
        method: 'PUT',
        url: BASE_URL + 'appdata/' + APP_KEY + '/ads/' + adId,
        headers: {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')},
        data: {publisher, title, description, datePublished, price, imagePath},

    }).then(function (res) {
        listAds();
        //showAllAds('viewAds');
        showInfo('Ad edited');
    }).catch(handleAjaxError);
}

function saveAuthInSession(userInfo) {
    sessionStorage.setItem('username', userInfo.username);
    sessionStorage.setItem('authToken', userInfo._kmd.authtoken);
    sessionStorage.setItem('userId', userInfo._id);
}

function logoutUser() {
    sessionStorage.clear();
    showHomeView();
    showHideMenuLinks();
    showInfo('Logout successful.');

}

function signInUser(res, message) {
    saveAuthInSession(res);
    showHomeView();
    showHideMenuLinks();
    showInfo(message);
}

function action(type, adId) {
    let currentRow = $('#' + adId);
    $.ajax({
        url: BASE_URL + 'appdata/' + APP_KEY + '/ads/'+ adId,
        headers: {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')}
    }).then(function (res) {
            switch (type){
                case 'read':
                    showSingleView(res);
                    break;
                case 'edit':
                showEditAdView(res);
                break;
                case 'delete':
                    currentRow.remove();
                    deleteAd(res);
            }
    }).catch(handleAjaxError);
}


