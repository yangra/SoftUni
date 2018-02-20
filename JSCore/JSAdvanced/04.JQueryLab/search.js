function search() {
   let targetValue =  $('#searchText').val();
   let count = 0;
   $('#towns').find('li').each((index, element)=>{
       $(element).css('font-weight', 'normal');
       if(element.textContent.includes(targetValue)){
           $(element).css('font-weight', 'bold');
           count++;
       }
   });

   $('#result').text(`${count} matches found.`)
}