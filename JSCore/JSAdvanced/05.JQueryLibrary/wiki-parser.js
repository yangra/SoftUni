function wikiParser(selector) {
    let italicPattern = /([']{2})([^'].*?[^'])\1/g;
    let boldPattern = /([']{3})([^'].*?[^'])\1/g;
    let h1Pattern = /([=])([^=](.*?)[^=])\1/g;
    let h2Pattern = /([=]{2})([^=](.*?)[^=])\1/g;
    let h3Pattern = /([=]{3})([^=](.*?)[^=])\1/g;
    let linkPattern = /\[\[([^\[\]|]*?)]]/g;
    let linkTextPattern = /\[\[([^\[\]]*?)\|([^\[\]]*?)]]/g;

    let paragraph = $(selector);
    let text = paragraph.text();
    console.log(text);
    text = text.replace(boldPattern, (match, group1,group2) => '<b>' + group2 + '</b>');
    text = text.replace(italicPattern, (match, group1,group2) => '<i>' + group2 + '</i>');
    text = text.replace(h3Pattern, (match, group1, group2) => '<h3>' + group2 + '</h3>');
    text = text.replace(h2Pattern, (match, group1,group2) => '<h2>' + group2 + '</h2>');
    text = text.replace(h1Pattern, (match, group1,group2) => '<h1>' + group2 + '</h1>');
    text = text.replace(linkPattern, (match, group1) => '<a href="/wiki/' + group1 + '">' + group1 + '</a>');
    text = text.replace(linkTextPattern, (match, group1, group2) => '<a href="/wiki/' + group1 + '">' + group2 + '</a>');
    paragraph.html(text);
}