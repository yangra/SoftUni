handlers.user = (() => {
    function follow(ctx) {
        let username = ctx.params.username.substr(1);
        chirpService.follow(username)
            .then(() => {
                auth.showInfo(`Subscribed to ${username}`);
                ctx.redirect('#/feed');
            })
            .catch(auth.handleError);
    }

    function unfollow(ctx) {
        let username = ctx.params.username.substr(1);
        chirpService.unfollow(username)
            .then(()=>{
                auth.showInfo(`Unsubscribed to ${username}`);
                ctx.redirect('#/feed');
            })
            .catch(auth.handleError);
    }

    function differentUser(ctx) {
        ctx.username = ctx.params.username.substr(1);
        displayUserFeed(ctx);
    }

    function userFeed(ctx) {
        ctx.username = sessionStorage.getItem('username');
        displayUserFeed(ctx)
    }

    function displayUserFeed(ctx) {
        chirpService.viewAllChirpsByUser(ctx.username)
            .then(async (res) => {
                res.map(c => {
                    let time = timeHandler.calcTime(c._kmd.lmt);
                    c.time = time;
                    c.chirpId = c._id;
                    if(sessionStorage.getItem('username') === c.author ){
                        c.isAuthor = true;
                    }
                    return c;
                });
                ctx.chirps = res;
                ctx.noChirps = ctx.chirps.length === 0;

                ctx.numberOfChirps =  await chirpService.countChirps(ctx.username);
                ctx.following =  await chirpService.countFollowing(ctx.username);
                ctx.followers =  await chirpService.countFollowers(ctx.username);

                ctx.isMe = ctx.username === sessionStorage.getItem('username');
                ctx.isFollowing = JSON.parse(sessionStorage.getItem('subscriptions')).includes(ctx.username);

                ctx.loadPartials({
                    header: './templates/common/header.hbs',
                    footer: './templates/common/footer.hbs',
                    menu: './templates/common/menu.hbs',
                    article: './templates/chirp.hbs',
                }).then(function () {
                    this.partial('./templates/profile.hbs');
                });
            })
            .catch(auth.handleError);
    }

    function discover(ctx) {
        chirpService.listUsers().then((data)=>{
            ctx.users = data.map(e=>{
                e.followers = e.subscriptions.length;
                e.userId = e._id;
                return e;
            });

            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
                menu: './templates/common/menu.hbs',
                userbox: './templates/userbox.hbs',
            }).then(function () {
                this.partial('./templates/discover.hbs');
            });
        }).catch(auth.handleError);
    }

    return{
        follow,
        unfollow,
        differentUser,
        userFeed,
        discover
    }
})();