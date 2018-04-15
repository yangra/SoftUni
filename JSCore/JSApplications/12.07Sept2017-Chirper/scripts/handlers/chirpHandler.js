handlers.chirp = (() => {
    function createChirp(ctx) {
        let text = ctx.params.text;
        chirpService.createChirp(text).then(() => {
            auth.showInfo("Chirp published.");
            ctx.redirect('#/user-feed');
        }).catch(auth.handleError);
    }

    function deleteChirp(ctx) {
        let chirpId = ctx.params.chirpId.substr(1);
        chirpService.deleteChirp(chirpId).then(() => {
            auth.showInfo("Chirp deleted.");
            ctx.redirect('#/user-feed');
        }).catch(auth.handleError);

    }

    return {
        createChirp,
        deleteChirp,
    }
})();