function solution(command) {

    let postVoter = {
        id: 0,
        author: 'admin',
        content: 'password',
        upvotes: 0,
        downvotes: 0,

        upvote: () => {
            this.upvotes++;
        },

        downvote: () => {
            this.downvotes++;
        },

        score: () => {
            let positive = this.upvotes;
            let negative = this.downvotes;
            let balance = positive - negative;
            let totalVotes = positive + negative;
            let addedNumber = 0;
            if (positive + negative > 50) {
                addedNumber = Math.ceil(Math.max(positive, negative) * 0.25);
            }


            if (totalVotes >= 10 && positive / (positive + negative) > 0.66) {
                positive += addedNumber;
                negative += addedNumber;
                return [positive, negative, balance, "hot"];
            }

            if (balance >= 0 && (positive > 100 || negative > 100)) {
                positive += addedNumber;
                negative += addedNumber;
                return [positive, negative, balance, "controversial"];
            }

            if (totalVotes >= 10 && balance < 0) {
                positive += addedNumber;
                negative += addedNumber;
                return [positive, negative, balance, "unpopular"];
            }

            positive += addedNumber;
            negative += addedNumber;
            return [positive, negative, balance, "new"];
        }

    };

    return postVoter[command]();
}


let post = {
    id: '3',
    author: 'emil',
    content: 'wazaaaaa',
    upvotes: 100,
    downvotes: 100
};
solution.call(post, 'upvote');
solution.call(post, 'downvote');
let score = solution.call(post, 'score');// [127, 127, 0, 'controversial']
for (let i = 0; i < 50; i++) {
    solution.call(post, 'downvote');
}
score = solution.call(post, 'score');// [139, 189, -50, 'unpopular']