function fibonator(size){
    let first = 0;
    let second = 1;
    return function(){
        let next = first +second;
        first = second;
        second = next;
        return first;
    }
}

let fib = fibonator();
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());