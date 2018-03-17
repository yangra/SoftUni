class MailBox {
    constructor() {
        this._messages = new Map();
    }

    addMessage(subject, text) {
        if (!this._messages.has(subject)) {
            this._messages.set(subject, [])
        }
        this._messages.get(subject).push(text);
        return this;
    }

    get messageCount() {
        if (this._messages.size === 0) {
            return 0;
        }
        return [...this._messages.values()].map(v => v.length).reduce((a, b) => a + b);
    }

    deleteAllMessages() {
        this._messages = new Map();
    }

    findBySubject(str) {
        let subjectMatch = [...this._messages.keys()].filter(s => s.indexOf(str) !== -1);
        if (subjectMatch.length === 0) {
            return [];
        }

        let result = [];
        for (let key of subjectMatch) {
            let messageMatch = this._messages.get(key).map(v => {
                return {'subject': key, 'text': v}
            });
            for (let obj of messageMatch) {
                result.push(obj);
            }
        }

        return result;
    }

    toString() {
        if (this._messages.size === 0) {
            return ' * (empty mailbox)';
        }

        let output = '';
        let count = 0;
        for (let [key, val] of this._messages) {
            for (let i = 0; i < val.length; i++) {
                output += ` * [${key}] ${val[i]}`;
                output += this.messageCount - 1 === count ? '' : '\n';
                count++;
            }

        }
        return output;
    }
}

let mb = new MailBox();
console.log("Msg count: " + mb.messageCount);
console.log('Messages:\n' + mb);
mb.addMessage("meeting", "Let's meet at 17/11");
mb.addMessage("beer", "Wanna drink beer tomorrow?");
mb.addMessage("question", "How to solve this problem?");
mb.addMessage("Sofia next week", "I am in Sofia next week.");
console.log("Msg count: " + mb.messageCount);
console.log('Messages:\n' + mb);
console.log("Messages holding 'rakiya': " +
    JSON.stringify(mb.findBySubject('rakiya')));
console.log("Messages holding 'ee': " +
    JSON.stringify(mb.findBySubject('ee')));

mb.deleteAllMessages();
console.log("Msg count: " + mb.messageCount);
console.log('Messages:\n' + mb);

console.log("New mailbox:\n" +
    new MailBox()
        .addMessage("Subj 1", "Msg 1")
        .addMessage("Subj 2", "Msg 2")
        .addMessage("Subj 3", "Msg 3")
        .addMessage("Subj 3", "Msg bla")
        .addMessage("Subj 4", "Msg 4")
        .toString());
