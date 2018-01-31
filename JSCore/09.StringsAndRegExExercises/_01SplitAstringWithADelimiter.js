function splitString(str, delimiter) {
    str.split(delimiter).forEach(s => console.log(s));
}

splitString('One-Two-Three-Four-Five', '-');
splitString('http://platform.softuni.bg', '.');