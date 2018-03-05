function trackBugs() {
    let id = 0;
    let reports = [];
    let element = null;
    function report(author, description, reproducible, severity) {
        let newReport = {
            ID: id++,
            author,
            description,
            reproducible,
            severity,
            status: 'Open',
            toString: function () {
                return `${this.author},${this.ID}, ${this.severity}`;
            }
        };
        reports.push(newReport);
        output(element);
    }

    function setStatus(id, newStatus) {
        reports[id].status = newStatus;
        output(element);
    }

    function remove(id) {
        reports = reports.slice(0, id).concat(reports.slice(id + 1));
        output(element);
    }

    function sort(method) {
        function comparator() {
            switch (method) {
                case 'author':
                    return (a, b) => a.author.localeCompare(b.author);
                case 'severity':
                    return (a, b) => a.severity - b.severity;
                default:
                    return (a, b) => a.ID - b.ID;
            }
        }

        reports.sort(comparator());
        output(element);
    }

    function output(selector) {
        element = $(selector);
        element.empty();
        for (let report of reports) {
            let nextReport = $('<div>').attr('id', `report_${report.ID}`).addClass('report')
                .append($('<div>').addClass('body')
                    .append($('<p>').text(`${report.description}`)))
                .append($('<div>').addClass('title')
                    .append($('<span>').addClass('author').text(`Submitted by: ${report.author}`))
                    .append($('<span>').addClass('status').text(`${report.status} | ${report.severity}`))
                );

            element.append(nextReport);
        }
    }

    return {report, setStatus, remove, sort, output};
}


let tracker = trackBugs();
tracker.output('#content');
tracker.report('guy','report content', true, 5);
tracker.report('sec guy','report content 2', true, 3);
tracker.report('abv','report content three', true, 4);

tracker.sort('severity');

tracker.remove(1);
