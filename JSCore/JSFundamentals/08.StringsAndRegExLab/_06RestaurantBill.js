function restBill(arr){
    let products = arr.filter((e,i)=> i%2 === 0).join(', ');
    let sum = arr.filter((e,i)=> i%2 !== 0).map(e=>Number(e)).reduce((a,b)=>a+b);

    console.log(`You purchased ${products} for a total sum of ${sum}`);
}

restBill(['Beer Zagorka', '2.65', 'Tripe soup', '7.80','Lasagna', '5.69']);