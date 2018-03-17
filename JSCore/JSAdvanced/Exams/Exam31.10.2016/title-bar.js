

class TitleBar{
    constructor(title){
        this.title = title;
        this.linkList = new Map();
    }

    addLink(href, name){
        this.linkList.set(href, name);
    }

    appendTo(selector){
        let element = this._buildElement();
        $(selector).append(element);
    }

    _buildElement(){
        let header = $('<header>').addClass('header');
        let headerRow = $('<div>').addClass('header-row');
        let btn = $('<a class="button">&#9776;</a>');
        let title = $('<span>').addClass('title').text(`${this.title}`);
        let drawerDiv = $('<div>').addClass('drawer');
        btn.on('click',()=>drawerDiv.toggle());
        let nav = $('<nav>').addClass('menu');
        for (let [href,name] of this.linkList) {
            let link = $('<a>').addClass('menu-link').attr('href',href).text(name);
            nav.append(link);
        }
        headerRow.append(btn).append(title);
        drawerDiv.append(nav);
        header.append(headerRow).append(drawerDiv);
        return header;
    }
}

let titleBar = new TitleBar('New title');
titleBar.addLink('http://abv.bg','abv');
titleBar.addLink('http://gmail.com','gmail');
titleBar.addLink('http://facebook.com','facebook');
titleBar.appendTo('#container');
console.log(titleBar);