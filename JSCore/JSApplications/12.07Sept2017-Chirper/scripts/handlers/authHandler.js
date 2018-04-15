handlers.auth = (()=>{
    function loginPost(ctx){
        let username = ctx.params.username;
        let password = ctx.params.password;

        auth.login(username, password, false).then((userData) => {
            auth.saveSession(userData);
            auth.showInfo('Successfully logged in.');
            ctx.redirect('#/feed');
        }).catch((err) => {
            auth.handleError(err);
        });
    }

    function loginIndex(ctx) {
        ctx.loggedIn = auth.isAuth();

        if (auth.isAuth()) {
            ctx.username = sessionStorage.getItem('username');

            chirpService.listAllChirpsByFollowers()
                .then(async (res) => {
                    res.map(c => {
                        let time = timeHandler.calcTime(c._kmd.lmt);
                        c.time = time;
                        return c;
                    });
                    ctx.chirps = res;

                    ctx.numberOfChirps =  await chirpService.countChirps(ctx.username);
                    ctx.following = await chirpService.countFollowing(ctx.username);
                    ctx.followers = await chirpService.countFollowers(ctx.username);

                    ctx.loadPartials({
                        header: './templates/common/header.hbs',
                        footer: './templates/common/footer.hbs',
                        menu: './templates/common/menu.hbs',
                        chirp: './templates/chirp.hbs',
                    }).then(function () {
                        this.partial('./templates/feed.hbs');
                    });
                })
                .catch(auth.handleError);


        } else {
            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
                indexMenu: './templates/common/indexMenu.hbs',
            }).then(function () {
                this.partial('./templates/login.hbs');
            });
        }
    }

    function logout(ctx) {
        auth.logout().then(() => {
            sessionStorage.clear();
            auth.showInfo('Successfully logged out.');
            ctx.redirect('#/index.html');

        }).catch((err) => {
            auth.handleError(err);
        });
    }

    function register(ctx) {
        ctx.loadPartials({
            header: './templates/common/header.hbs',
            footer: './templates/common/footer.hbs',
            regMenu: './templates/common/regMenu.hbs',
        }).then(function () {
            this.partial('./templates/register.hbs');
        });
    }

    function registerPost(ctx) {
        let username = ctx.params.username;
        let password = ctx.params.password;
        let repeatPass = ctx.params.repeatPass;
        let subscriptions = [];

        if (password !== repeatPass) {
            auth.showError("Passwords do not match!");
        } else {
            auth.register(username, password, subscriptions).then(function (userData) {
                auth.login(userData.username, userData.password)
                    .then(()=>{
                        auth.saveSession(userData);
                        auth.showInfo("Successfully registered.");
                        ctx.redirect("#/feed");
                    })
                    .catch(auth.handleError);
            }).catch(auth.handleError);
        }
    }

    return{
        loginPost,
        loginIndex,
        logout,
        register,
        registerPost,
    }
})();