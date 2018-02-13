function tablify(arr) {
    let table = [];
    let result = '';
    for (let line of arr) {
        table.push(JSON.parse(line));
    }

    result += '<table>\n';
    for (let obj of table) {
        result += '  <tr>\n';
        result += `      <td>${htmlEscape(obj.name)}</td>\n`;
        result += `      <td>${htmlEscape(obj.position)}</td>\n`;
        result += `      <td>${Number(obj.salary)}</td>\n`;
        result += '  <tr>\n';
    }
    result += '</table>';
    console.log(result);

    function htmlEscape(text) {
        let map = { '"': '&quot;', '&': '&amp;',
            "'": '&#39;', '<': '&lt;', '>': '&gt;' };
        return text.replace(/[\"&'<>]/g, ch => map[ch]);
    }
}

tablify(['{"name":"Pesho","position":"Promenliva","salary":100000}',
    '{"name":"Teo","position":"Lecturer","salary":1000}',
    '{"name":"Georgi","position":"Lecturer","salary":1000}']);