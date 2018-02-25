(function () {
    return solution =  {
        add: (vec1, vec2) => [vec1[0] + vec2[0], vec1[1] + vec2[1]],
        multiply: (vec1, scalar) => [vec1[0] * scalar, vec1[1] * scalar],
        length: (vec) => Math.sqrt(vec[0] * vec[0] + vec[1] * vec[1]),
        dot: (vec1, vec2) => vec1[0] * vec2[0]+ vec1[1] * vec2[1],
        cross: (vec1, vec2) => vec1[0] * vec2[1]- vec1[1] * vec2[0]
    }
})();

console.log(solution.add([1, 1], [1, 0]));
console.log(solution.multiply([3.5, -2], 2));
console.log(solution.length([3, -4]));
console.log(solution.dot([1, 0], [0, -1]));
console.log(solution.cross([3, 7], [1, 0]));