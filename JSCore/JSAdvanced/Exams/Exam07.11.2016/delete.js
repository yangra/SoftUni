function attachEvents() {
    let delBtn = $('#btnDelete');
    delBtn.on('click', ()=>{
        let select = $('#towns');
        let input = $('#townName');
        let result = $('#result');
        let pattern = new RegExp(`^\\${input.val()}$`);
        let matched = false;
        for (let town of select.children().toArray()) {
            if(pattern.test($(town).text())){
                result.text(`${$(town).text()} deleted.` );
                $(town).remove();
                matched = true;
            }
        }
        if(!matched){
            result.text(`${input.val()} not found.`)
        }
        input.val('');
    });
}