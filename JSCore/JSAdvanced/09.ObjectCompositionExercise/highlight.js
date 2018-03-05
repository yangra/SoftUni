function highlight(selector) {
    let element = $(selector);
    let deepestElement = element;

    let maxDepth = 0;
    DFS(element, 0);
    changeCSS(element);

    function DFS(element, depth) {
        if (depth > maxDepth) {
            maxDepth = depth;
            deepestElement = element;
        }

        for (let child of element.children()) {
            DFS($(child), depth + 1);
        }

    }

    function changeCSS(element) {
        if (element[0] === deepestElement[0]) {
            element.addClass('highlight');
            return;
        }

        for (let child of element.children()) {
            changeCSS($(child));
        }

        if (element[0] === $(deepestElement.parent())[0]) {
            element.addClass('highlight');
            deepestElement = element;
        }
    }
}

