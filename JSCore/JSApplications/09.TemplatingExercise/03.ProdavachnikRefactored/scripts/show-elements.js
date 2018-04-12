async function showView(viewTemplate, viewObj) {
    let source = await $.get('./templates/' + viewTemplate + '.hbs');
    let compiled = Handlebars.compile(source);
    let template = compiled(viewObj);
    $('#page').html(template);
}

async function showHideMenuLinks() {
    let authToken = sessionStorage.getItem('authToken');
    let headers = window.headers.unAuthHeaders;
    if (authToken) {
        headers = window.headers.authHeaders;
        $('#loggedInUser').text("Welcome, " + sessionStorage.getItem('username') + "!")
    } else {
        $('#loggedInUser').text('');
    }
    let source = await $.get('./templates/header-template.hbs');
    let compiled = Handlebars.compile(source);
    let template = compiled({
        headers
    });
    let menu = $('#menu');
    if (menu.length) {
        menu.html(template);
    } else {
        $('#header').append(template);
    }

    attachEventsToLinks();
}

function showInfo(message) {
    let msgObj = {
        type: 'infoBox',
        text: message,
    };
    compileBoxElement(msgObj).then(function () {
        setTimeout(function () {
            $('#infoBox').fadeOut()
        }, 3000)
    }).catch(handleAjaxError);
}

function showError(errorMsg) {
    let msgObj = {
        type: 'errorBox',
        text: errorMsg,
    };
    compileBoxElement(msgObj).catch(handleAjaxError);
}

async function compileBoxElement(msgObj) {
    let source = await  $.get('./templates/box.hbs');
    let compiled = Handlebars.compile(source);
    let box = compiled(msgObj);
    $('#header').append(box);
    if (msgObj.type === 'errorBox') {
        $('#errorBox').on('click', function () {
            $(this).fadeOut();
        });
    } else if (msgObj.type === 'infoBox') {
        $('#infoBox').on('click', function () {
            $(this).fadeOut();
        });

    }
}

function showHomeView() {
    showView('home-view').catch(handleAjaxError);
}

function showLoginView() {
    let obj = {
        viewType: 'viewLogin',
        formType: 'formLogin',
        formTitle: 'Please login',
        buttonType: 'buttonLoginUser',
        value: 'Login',
    };
    showView('login-register-view', obj).then(function () {
        $('#formLogin').trigger('reset');
        $("#buttonLoginUser").on('click', loginUser);
    }).catch(handleAjaxError);

}

function showRegisterView() {
    let obj = {
        viewType: 'viewRegister',
        formType: 'formRegister',
        formTitle: 'Please register here',
        buttonType: 'buttonRegisterUser',
        value: 'Register',
    };
    showView('login-register-view', obj).then(function () {
        $('#formRegister').trigger('reset');
        $("#buttonRegisterUser").on('click', registerUser);
    }).catch(handleAjaxError);

}

function showCreateAdView() {
    let obj = {
        viewType: 'viewCreateAd',
        formType: 'formCreateAd',
        formTitle: 'Create new Advertisement',
        buttonType: 'buttonCreateAd',
        value: 'Create',
    };
    showView('create-edit-view', obj).then(function () {
        $('#formCreateAd').trigger('reset');
        $("#buttonCreateAd").on('click', createAd);
    }).catch(handleAjaxError);

}

function showEditAdView(ad) {
    let obj = {
        id: ad._id,
        publisher: ad._acl.creator,
        title: ad.title,
        description: ad.description,
        datePublished: ad.datePublished,
        price: ad.price,
        imagePath: ad.imagePath,
        viewType: 'viewEditAd',
        formType: 'formEditAd',
        formTitle: 'Edit existing advertisement',
        buttonType: 'buttonEditAd',
        value: 'Edit',
    };
    if(ad.edit){
        obj.edit = true;
    }
    showView('create-edit-view', obj).then(function () {
        console.log(obj);
        $("#buttonEditAd").on('click', editAd);
        $('#formEditAd').trigger('reset');
    }).catch(handleAjaxError);

}

function showSingleView(ad) {
    showView('single-view', ad).then(function () {
        $('#formEditAd').trigger('reset');
    }).catch(handleAjaxError);

}

function showAllAds(ads) {
    showView('view-ads', {ads}).catch(handleAjaxError)
}