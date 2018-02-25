function countArgs(){

    let argTypes = new Map();
    for (let argument of arguments) {
       let type =  typeof argument;
       if(argTypes.has(type)){
           argTypes.set(type, argTypes.get(type)+1);
       }else{
           argTypes.set(type, 1);
       }

       console.log(type +': '+ argument);
    }

    let sortedKeys = Array.from(argTypes.keys()).sort((a,b)=> argTypes.get(b) - argTypes.get(a));
    for (let key of sortedKeys) {
        console.log(key + " = " +argTypes.get(key));
    }
}

countArgs('cat', 42, function () { console.log('Hello world!'); });