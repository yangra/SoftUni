(function () {
    String.prototype.ensureStart = function (str) {
        let text = this.valueOf();
        if (!text.startsWith(str)) {
            let result = str;
            result += text;
            return result;
        }
        return text;
    };
    String.prototype.ensureEnd = function (str) {
        let text = this.valueOf();
        if (!text.endsWith(str)) {
            return text+ str;
        }
        return text;
    };

    String.prototype.isEmpty = function () {
        if (this.valueOf().length === 0) {
            return true;
        }
        return false;
    };
    String.prototype.truncate = function (n) {
        let result = this.valueOf();
        if (n < 4) {
            return '.'.repeat(n);
        } else if (this.length <= n) {
            return result;
        } else if (this.indexOf(' ') === -1) {
            return result.slice(0, n - 3) + '...';
        } else {
            while (result.length + 3 > n) {
                result = result.slice(0, result.lastIndexOf(' '));
                if (result.length + 3 > n && result.indexOf(' ') === -1) {
                    return result.slice(0, this.length - 3) + '...';
                }
            }
            return result + '...';
        }
    };

    String.format = function (string, ...params) {
        let patternPlaceholder = /{([0-9])}/g;
        string = string.replace(patternPlaceholder,
            (match, group1) => params.length > Number(group1) ? params[Number(group1)] : match);
        return string;
    }
})();
