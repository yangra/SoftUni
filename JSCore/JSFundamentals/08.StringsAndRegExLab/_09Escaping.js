function escape(arr){
    let result = '<ul>\n';
    for (let str of arr) {
        result += '   <li>' + escapeChars(str) + '</li>\n'
    }
    result += '</ul>' ;
    console.log(result);

    function escapeChars(str){
    return str.replace(/&/g, '&amp;')
        .replace(/</g, '&lt;')
        .replace(/>/g, '&gt;')
        .replace(/"/g, '&quot;')
        .replace(/'/g, '&#39;');}
}

escape(['<div style=\"color: red;\">Hello, Red!</div>', '<table><tr><td>Cell 1</td><td>Cell2</td><tr>'])
