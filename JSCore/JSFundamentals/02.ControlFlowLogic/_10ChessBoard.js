function printChessBoard(n) {
    let html = `<div class="chessboard">\n`;
    for (let i = 0; i < n; i++) {
        html+='<div>\n';
        for (let j = 0; j < n; j++) {
            let color;
            if (i % 2 === 0 && j % 2 === 0 || Math.abs(i % 2) !== 0 && Math.abs(j % 2) !== 0) {
                color = 'black';
            } else {
                color = 'white';
            }
            html += `    <span class="${color}"></span>\n`;
        }
        html+='</div>\n';
    }

    html+= '</div>';

    return html;
}

printChessBoard(4);