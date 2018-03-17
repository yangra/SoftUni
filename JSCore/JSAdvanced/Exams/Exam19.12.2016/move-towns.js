function move(direction) {

    let select = $('#towns');
    let options  =  select.children();
    let selected = options.toArray().filter(o=>$(o).is(':selected'));
    let index = options.toArray().indexOf(selected[0]);
    if(direction>0){
        swap(index,index+1);
    }else{
        swap(index-1,index);
    }
    select.append(options);

    function swap(leftIndex, rightIndex) {
        let first =  options.toArray()[leftIndex];
        let second =  options.toArray()[rightIndex];
        let temp = first;
        options[leftIndex] = second;
        options[rightIndex] = temp;
    }
}