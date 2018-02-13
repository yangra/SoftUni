function parseHTMLTable(strArr){
    let arr = JSON.parse(strArr);
    let str = '<table>\n';
    let keys = Object.keys(arr[0]);
    str += '    <tr>';
    for (let key of keys) {
        str+= `<th>${key}</th>`
    }
    str+='</tr>\n';

    for (let obj of arr) {
        str += '    <tr>';
        for (i=0;i<Object.keys(obj).length;i++) {
            str += `<td>${escapeChars(obj[keys[i]]+'')}</td>`
        }
        str+='</tr>\n';

    }
    str += '</table>';
    console.log(str);

    function escapeChars(string) {
        return string.replace(/&/g, '&amp;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#39;');
    }
}

parseHTMLTable('[{"Name":"Tomatoes & Chips","Price":2.35},{"Name":"J&B Chocolate","Price":0.96}]');