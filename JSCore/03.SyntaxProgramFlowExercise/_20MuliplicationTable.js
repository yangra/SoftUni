function multiplicationTable(n){
    console.log('<table border="1">');
    let line = '<tr><th>x</th>';
    for (let i = 1; i <= n; i++) {
        line += `<th>${i}</th>`;
    }
    line+='</tr>';
    console.log(line);

    for (let row = 1; row <= n; row++) {
        line = '<tr>';
        line += `<th>${row}</th>`;
        for (let col = 1; col <= n; col++) {
            line += `<td>${row*col}</td>`;
        }
        line += '</tr>';
        console.log(line);
    }

    console.log('</table>');
}

multiplicationTable(5)