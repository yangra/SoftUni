function format(arr) {
    arr[0] = arr[0].replace(/([.,!?:;])(\s*)/g, (match,group1) => group1 + ' ');
    arr[0] = arr[0].replace(/(?:\s+)([.,!?:;])/g, (match,group1) => group1);
    arr[0] = arr[0].replace(/(\s+([.!?;])\s+)+/g, (match) => match.replace(/\s+/g, ''));
    arr[0] = arr[0].replace(/(\s*([.])\s*\d+)+/g, (match) => match.replace(/\s+/g, ''));
    arr[0] = arr[0].replace(/"([^"]+)"/g, (match, group1) => match.replace(group1, group1.trim()));
    console.log(arr[0]);
}

format(['Terribly formatted text        .    With chaotic spacings." Terrible quoting "! Also this date is pretty confusing : 20 . 12. 16 .']);
format(['Make,sure to give:proper spacing where is needed... !']);