function move(command) {
    let aTowns = $('#available-towns');
    let sTowns = $('#selected-towns');
    if (command === 'left') {
        let selected = sTowns.children().toArray().filter(c => $(c).is(':selected'));
        if (selected !== undefined) {
            $(selected).remove;
            aTowns.append($(selected));
        }
    } else if (command === 'right') {
        let selected = aTowns.children().toArray().filter(c => $(c).is(':selected'));
        if (selected !== undefined) {
            $(selected).remove;
            sTowns.append($(selected));
        }
    } else {
        let result = sTowns.children().toArray().map(e=>$(e).text()).join('; ');
        $('#output').text(result);
    }
}