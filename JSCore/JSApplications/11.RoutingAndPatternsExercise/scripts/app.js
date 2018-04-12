const handlers = {};

$(() => {
    const app = Sammy('#main', function () {
        this.use('Handlebars', 'hbs');

        this.get('index.html', handlers.homeHandler);
        this.get('#/home', handlers.homeHandler);

        this.get('#/about', (ctx) => {
            ctx.loggedIn = auth.isAuth();
            ctx.username = sessionStorage.getItem('username');

            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
            }).then(function () {
                this.partial('./templates/about/about.hbs');
            });
        });

        this.get('#/login', (ctx) => {
            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
                loginForm: './templates/login/loginForm.hbs',
            }).then(function () {
                this.partial('./templates/login/loginPage.hbs');
            });
        });

        this.post('#/login', (ctx) => {
            let username = ctx.params.username;
            let password = ctx.params.password;


            auth.login(username, password).then((userData) => {
                auth.saveSession(userData);
                ctx.redirect('#/home');
            }).catch((err) => {
                auth.handleError(err);
            });

        });

        this.get('#/register', (ctx) => {
            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
                registerForm: './templates/register/registerForm.hbs',
            }).then(function () {
                this.partial('./templates/register/registerPage.hbs');
            })
        });

        this.post('#/register', (ctx) => {
            let username = ctx.params.username;
            let password = ctx.params.password;
            let repeatPass = ctx.params.repeatPassword;

            if (password !== repeatPass) {
                auth.showError("Passwords do not match!");
            } else {
                auth.register(username, password).catch((err) => {
                    auth.handleError(err);
                });
                ctx.redirect('#/home');
            }
        });

        this.get('#/logout', (ctx) => {
            auth.logout().then(() => {
                sessionStorage.clear();
                ctx.redirect('#/home');

            }).catch((err) => {
                auth.handleError(err);
            });
        });

        this.get('#/catalog', (ctx) => {
            ctx.loggedIn = auth.isAuth();
            ctx.username = sessionStorage.getItem('username');

            ctx.hasNoTeam = !auth.isMember();
            teamsService.loadTeams()
                .then((res) => {
                    ctx.teams = res;
                    //console.log(res);
                    ctx.loadPartials({
                        header: './templates/common/header.hbs',
                        footer: './templates/common/footer.hbs',
                        team: './templates/catalog/team.hbs',
                    }).then(function () {
                        this.partial('./templates/catalog/teamCatalog.hbs');
                    })

                }).catch(function (err) {
                auth.handleError(err);
            });
        });

        this.get('#/catalog/:_id', (ctx) => {
            teamsService.loadTeamDetails(ctx.params._id.substr(1)).then((data) => {
                ctx.loggedIn = auth.isAuth();
                ctx.username = sessionStorage.getItem('username');
                ctx.name = data.name;
                ctx.isOnTeam = false;
                if (data.comment) {
                    ctx.comment = data.comment;
                }
                if (data.members) {
                    let parsedMembers = JSON.parse(data.members);
                    ctx.members = parsedMembers.map(e => {
                        obj = {username: e};
                        return obj;
                    });
                    ctx.isOnTeam = parsedMembers.includes(sessionStorage.getItem('username'));
                }
                ctx.isAuthor = data._acl.creator === sessionStorage.getItem('userId');
                ctx.teamId = ctx.params._id.substr(1);

                ctx.loadPartials({
                    header: './templates/common/header.hbs',
                    footer: './templates/common/footer.hbs',
                    teamMember: './templates/catalog/teamMember.hbs',
                    teamControls: './templates/catalog/teamControls.hbs',
                }).then(function () {
                    this.partial('./templates/catalog/details.hbs');
                })
            })

        });


        this.get('#/create', (ctx) => {
            ctx.loggedIn = auth.isAuth();
            ctx.username = sessionStorage.getItem('username');

            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
                createForm: './templates/create/createForm.hbs',
            }).then(function () {
                this.partial('./templates/create/createPage.hbs');
            })
        });


        this.post('#/create', (ctx) => {
            let name = ctx.params.name;
            let comment = ctx.params.comment;
            teamsService.createTeam(name, comment).catch(function (err) {
                auth.handleError(err);
            })
        });

        this.get('#/edit/:teamId', (ctx) => {
            ctx.loggedIn = auth.isAuth();
            ctx.username = sessionStorage.getItem('username');
            ctx.teamId = ctx.params.teamId.substr(1);

            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
                editForm: './templates/edit/editForm.hbs',
            }).then(function () {
                this.partial('./templates/edit/editPage.hbs');
            })
        });


        this.post('#/edit/:teamId', (ctx) => {
            let teamId = ctx.params.teamId.substr(1);
            let name = ctx.params.name;
            let description = ctx.params.comment;

            teamsService.edit(teamId, name, description).then((res) => {
                ctx.redirect('#/catalog');
            }).catch(function (err) {
                auth.handleError(err);
            })
        });

        this.get('#/leave', (ctx) => {
            let teamId = sessionStorage.getItem('teamId');

            teamsService.loadTeamDetails(teamId).then((data) => {
                let members = JSON.parse(data.members);
                members = members.filter(m=>m!==sessionStorage.getItem('username'));
                if(members.length === 0){
                    teamsService.edit(data._id, data.name, data.comment).then(function () {
                        teamsService.leaveTeam().then(() => {
                            sessionStorage.removeItem('teamId');
                            ctx.redirect(`#/catalog/:${teamId}`);
                        }).catch(function (err) {
                            auth.handleError(err);
                        })
                    }).catch(function (err) {
                        auth.handleError(err);
                    })
                }else{
                    teamsService.editWithMembers(data._id, data.name, data.comment, JSON.stringify(members)).then(function () {
                        teamsService.leaveTeam().then(() => {
                            sessionStorage.removeItem('teamId');
                            ctx.redirect(`#/catalog/:${teamId}`);
                        }).catch(function (err) {
                            auth.handleError(err);
                        })
                    }).catch(function (err) {
                        auth.handleError(err);
                    })
                }


            }).catch(function (err) {
                auth.handleError(err);
            })
        });


        this.get('#/join/:teamId', (ctx) => {
            ctx.teamId = ctx.params.teamId.substr(1);
            teamsService.loadTeamDetails(ctx.teamId).then((data) => {
                let members = [];
                if (data.members) {
                    members = JSON.parse(data.members);
                }
                members.push(sessionStorage.getItem('username'));
                members = JSON.stringify(members);
                teamsService.editWithMembers(data._id, data.name, data.comment, members).then(function () {
                    teamsService.joinTeam(ctx.teamId).then(function () {
                        sessionStorage.setItem('teamId', `${ctx.teamId}`);
                        ctx.redirect(`#/catalog/:${ctx.teamId}`);
                    }).catch(function (err) {
                        auth.handleError(err);
                    });
                }).catch(function (err) {
                    auth.handleError(err);
                });


            }).catch(function (err) {
                auth.handleError(err);
            });

        });

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