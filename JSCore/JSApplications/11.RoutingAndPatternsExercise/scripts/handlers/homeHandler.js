handlers.homeHandler = function (ctx) {
    ctx.loggedIn = auth.isAuth();
    ctx.hasTeam = auth.isMember();
    ctx.username = sessionStorage.getItem('username');
    ctx.teamId = sessionStorage.getItem('teamId');

    ctx.loadPartials({
        header: './templates/common/header.hbs',
        footer: './templates/common/footer.hbs',
    }).then(function () {
        this.partial('./templates/home/home.hbs');
    });
};

