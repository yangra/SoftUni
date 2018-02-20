function processCommands(commands) {
    let commandProcessor = (function(){ let text = '';
        return {
            append: (s) => text += s,
            removeStart: (count) => text = text.slice(count),
            removeEnd: (count) => text =
                text.substring(0, text.length - count),
            print: () => console.log(text)
        } })();

    for (let cmd of commands) {
        let [cmdName, arg] = cmd.split(' ');
        commandProcessor[cmdName](arg);
    }
}

processCommands(['append hello',
    'append again',
    'removeStart 3',
    'removeEnd 4',
    'print']);