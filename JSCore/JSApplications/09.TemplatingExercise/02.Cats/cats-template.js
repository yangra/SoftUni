$(() => {
    renderCatTemplate();

    async function renderCatTemplate() {
        let cats = window.cats;
        let source = await $.get('./cat.hbs');
        let compiled = Handlebars.compile(source);
        let template = compiled({
            cats
        })
        $('body').append(template);

        $('.btn.btn-primary').each((i, btn) => {
            $(btn).on('click', (e) => {
                let div = $(e.target).parent().find('div');
                div.toggle()
            });
        })
    }

});
