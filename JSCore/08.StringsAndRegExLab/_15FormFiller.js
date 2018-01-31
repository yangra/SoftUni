function fillForm(username, email, phone, form) {

    let usernameRegex = /<![a-zA-Z]+!>/g;
    let emailRegex = /<@[a-zA-Z]+@>/g;
    let phoneRegex = /<\+[a-zA-Z]+\+>/g;

    for (let str of form) {
        str = str.replace(usernameRegex, username);
        str = str.replace(emailRegex, email);
        str = str.replace(phoneRegex, phone);
        console.log(str);
    }
}

fillForm('Pesho',
    'pesho@softuni.bg',
    '90-60-90',
    ['Hello, <!username!>!',
        'Welcome to your Personal profile.',
        'Here you can modify your profile freely.',
        'Your current username is: <!fdsfs!>. Would you like to change that? (Y/N)',
        'Your current email is: <@DasEmail@>. Would you like to change that? (Y/N)',
        'Your current phone number is: <+number+>. Would you like to change that? (Y/N)']);