function validate() {
    let usernamePattern = /(^[a-zA-Z0-9]{3,20}$)/;
    let passwordPattern = /(^\w{5,15}$)/;
    let emailPattern = /(^.+?@.*?(?:\..*?)+$)/;
    let companyPattern = /^[1-9][0-9]{3}$/;

    let username = $('#username');
    let password = $('#password');
    let confirmPassword = $('#confirm-password');
    let email = $('#email');
    let company = $('#company');
    let companyInfo = $('#companyInfo');
    let companyNumber = $('#companyNumber');
    let submit = $('#submit');

    company.on('change', () => {
        if (companyInfo.css('display') === 'block') {
            companyInfo.css('display', 'none');
            return;
        }

        companyInfo.css('display', 'block');
    });

    submit.on('click', (event) => {
        event.preventDefault();
        debugger;
        let validUsername = usernamePattern.test(username.val());
        let validPassword = passwordPattern.test(password.val());
        let validEmail = emailPattern.test(email.val());
        let validCompanyInfo = companyPattern.test(companyNumber.val());

        if (!validUsername) {
            username.css('border-color', 'red');
        } else {
            username.css('border-color', '');
        }
        if (!validPassword || password.val() !== confirmPassword.val()) {
            password.css('border-color', 'red');
            confirmPassword.css('border-color', 'red');
        } else {
            password.css('border-color', '');
            confirmPassword.css('border-color', '');
        }
        if (!validEmail) {
            email.css('border-color', 'red');
        } else {
            email.css('borde-color', '');
        }
        if (companyInfo.css('display') === 'block') {
            if (!validCompanyInfo) {
                companyNumber.css('border-color', 'red');
            } else {
                companyNumber.css('border-color', '');
            }
        }

        if (validUsername && validEmail && validPassword &&
            password.val() === confirmPassword.val()) {
            if (companyInfo.css('display') === 'block') {
                if (!validCompanyInfo) {
                    return;
                }
            }
            $('#valid').css('display', 'block');
        }
    });
}
