function parseEmployee(str) {
    let regex = /^([A-Z][a-zA-Z]*)\s-\s([1-9][0-9]*)\s-\s([a-zA-Z -]+)$/;
    for (let s of str) {
        let match = regex.exec(s);
        if (match) {
            console.log(`Name: ${match[1]}`);
            console.log(`Position: ${match[3]}`);
            console.log(`Salary: ${match[2]}`);
        }
    }
}

parseEmployee(['Isacc - 1000 - CEO', 'Ivan - 500 - Employee', 'Peter - 500 - Employee']);