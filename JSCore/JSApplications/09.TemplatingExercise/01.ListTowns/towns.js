function attachEvents() {
    $('#btnLoadTowns').on('click', () => {
        let towns = $('#towns').val();
        towns = towns.split(',').filter(e => e.trim() !== '').map(e => ({town: e.trim()}));
        renderTowns(towns);
    });

    $('.btn-primary').on('click', (e)=>{
        $(e.target).toggle();
    });
    async function renderTowns(towns) {
        let source = await $.get('./towns-template.hbs');
        let compiled = Handlebars.compile(source);
        let template = compiled({towns});
        $('#root').html(template);
    }
}