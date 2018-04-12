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
        showView('viewAds');
        displayPaginationAndAds(res.reverse());
    })
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
    showView('viewEditAd');
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
        showView('viewAds');
        showInfo('Ad edited');
    })
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


function renderSingleView(ad) {
let singleView = $('.viewSingleAd');
    singleView.find('#image').attr('src','');
    singleView.find('#image').attr('src',ad.imagePath);
    singleView.find('#title').text(ad.title);
    singleView.find('#description').text(ad.description);
    singleView.find('#publisher').text(ad.publisher);
    singleView.find('#date-published').text(ad.datePublished);
    singleView.find('#price').text(ad.price);
    showView('viewSingleAd');
}

function displayPaginationAndAds(ads) {
    let pagination = $('#pagination');
    if (pagination.data("twbs-pagination")) {
        pagination.twbsPagination('destroy');
    }
    pagination.twbsPagination({
        totalPages: Math.ceil(ads.length / ADS_PER_PAGE),
        visiblePages: 5,
        next: 'Next',
        prev: 'Prev',
        onPageClick: function (event, page) {
            let table = $('#ads > table');
            table.find('tr').each((index, element) => {
                if (index > 0) {
                    $(element).remove();
                }
            });
            let startAd = (page - 1) * ADS_PER_PAGE;
            let endAd = Math.min(startAd + ADS_PER_PAGE, ads.length);
            $(`a:contains(${page})`).addClass('active');
            for (let i = startAd; i < endAd; i++) {

                let tr = $(`<tr id="${ads[i]._id}">`);
                table.append(tr
                    .append(`<td>${ads[i].title}</td>`)
                    .append(`<td>${ads[i].publisher}</td>`)
                    .append(`<td>${ads[i].description}</td>`)
                    .append(`<td>${ads[i].price}</td>`)
                    .append(`<td>${ads[i].datePublished}</td>`));


                if (ads[i]._acl.creator === sessionStorage.getItem('userId')) {
                    tr.append($('<td>')
                        .append($(`<a href="#">[Read more]</a>`).on('click', function () {
                            renderSingleView(ads[i]);
                        }))
                        .append($(`<a href="#">[Edit]</a>`).on('click', function () {
                       loadAdForEdit(ads[i]);

                    })).append($(`<a href="#">[Delete]</a>`).on('click', function () {
                        deleteAd(ads[i]);
                    })));
                }else{
                    tr.append($('<td>').append(`<a href="#">[Read more]</a>`).on('click', function () {
                        renderSingleView(ads[i]);
                    }));
                }
            }
        }
    })
}

function handleAjaxError(response) {
    let errorMsg = JSON.stringify(response);
    if (response.readyState === 0)
        errorMsg = "Cannot connect due to network error.";
    if (response.responseJSON && response.responseJSON.description)
        errorMsg = response.responseJSON.description;
    showError(errorMsg)
}
