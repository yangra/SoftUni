const handlers = {};

$(() => {
    const app = Sammy('#main', function () {
        this.use('Handlebars', 'hbs');

        this.get('#/register', handlers.auth.register);
        this.post('#/register', handlers.auth.registerPost);

        this.get('index.html', handlers.auth.loginIndex);
        this.get('#/feed', handlers.auth.loginIndex);

        this.get('#/logout', handlers.auth.logout);

        this.post('#/login', handlers.auth.loginPost);

        this.post('#/create-chirp', handlers.chirp.createChirp);
        this.get('#/user-feed', handlers.user.userFeed);

        this.get('#/follow/:username',handlers.user.follow );
        this.get('#/unfollow/:username',handlers.user.unfollow );
        this.get('#/discover', handlers.user.discover);
        this.get('#/delete/:chirpId', handlers.chirp.deleteChirp );
        this.get('#/profile/:username', handlers.user.differentUser );

    });


// Attach AJAX "loading" event listener
    $(document).on({
        ajaxStart: function () {
            $('#loadingBox').show();
        },
        ajaxStop: function () {
            $("#loadingBox").hide();
        }
    });

    app.run();
})
;