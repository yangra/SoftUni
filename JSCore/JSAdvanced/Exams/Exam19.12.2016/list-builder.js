function listBuilder(selector) {
    let container = $(selector);
    return{
        createNewList: function () {
            container.empty();
            $('<ul>').appendTo(container);
        },
        addItem: function (text) {
            let btnUp = $('<button>').text('Up');
            let btnDown = $('<button>').text('Down');
            btnUp.on('click', (e)=>{
               let selectedLi =  $(e.target).parent();
                $(selectedLi).insertBefore($(selectedLi).prev());
            });

            btnDown.on('click',(e)=>{
                let selectedLi =  $(e.target).parent();
                $(selectedLi).insertAfter($(selectedLi).next());
            });

            container.find('ul').append($('<li>').text(text).append(btnUp).append(btnDown));
        }
    }
}