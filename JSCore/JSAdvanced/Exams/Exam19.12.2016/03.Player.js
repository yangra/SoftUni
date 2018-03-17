class Player {
    constructor(nickName) {
        this.nickName = nickName;
        this._scores = [];
    }

    addScore(score) {
        if (!isNaN(score)&&score!==null) {
            this._scores.push(Number(score));
            this._scores.sort((a, b) => b - a);
            return this;
        }
    }

    get scoreCount() {
        return this._scores.length;
    }

    get highestScore() {
        if (this._scores.length === 0) {
            return;
        }
        return this._scores[0];
    }

    get topFiveScore() {

        if (this._scores.length <= 5) {
            return this._scores;
        }
        return this._scores.slice(0, 5);
    }

    toString() {
        let scores = this._scores.join(',');
        return this.nickName + ': [' + scores + ']';
    }

}

let peter = new Player("Peter");
peter.addScore(null);
peter.addScore('peter');
console.log(peter.scoreCount);
console.log('Highest score: ' + peter.highestScore);
console.log(`Top 5 score: [${peter.topFiveScore}]`);
console.log('' + peter);
console.log('Score count: ' + peter.scoreCount);
peter.addScore(450);
peter.addScore(200);
console.log('Highest score: ' + peter.highestScore);
console.log(`Top 5 score: [${peter.topFiveScore}]`);
console.log('' + peter);
peter.addScore(2000);
peter.addScore(300);
peter.addScore(50);
peter.addScore(700);
peter.addScore(700);
console.log('Highest score: ' + peter.highestScore);
console.log(`Top 5 score: [${peter.topFiveScore}]`);
console.log('' + peter);
console.log('Score count: ' + peter.scoreCount);
console.log();
let maria = new Player("Maria")
    .addScore(350)
    .addScore(779)
    .addScore(180);
console.log('Highest score: ' + maria.highestScore);
console.log(`Top 5 score: [${maria.topFiveScore}]`);
console.log('' + maria);
