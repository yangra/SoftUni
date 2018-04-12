function attachEventsToLinks() {
    // Bind the navigation menu links
    $("#linkHome").on('click', showHomeView);
    $("#linkLogin").on('click', showLoginView);
    $("#linkRegister").on('click', showRegisterView);
    $("#linkListAds").on('click', listAds);
    $("#linkCreateAd").on('click', showCreateAdView);
    $("#linkLogout").on('click', logoutUser);

    // Bind the form submit buttons
    //
    //
    //
    // 
    //$("form").on('submit', function(event) { event.preventDefault() });

    // Attach AJAX "loading" event listener
    $(document).on({
        ajaxStart: function() {
            let msgObj = { type: 'loadingBox',text: 'Loading...',};
            compileBoxElement(msgObj);
            },
        ajaxStop: function() { $("#loadingBox").remove(); }
    })
}