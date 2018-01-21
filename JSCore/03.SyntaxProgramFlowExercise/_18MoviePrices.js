function calculateTicketPrice(input) {
    let [title, day] = input;
    if (title.toLowerCase() === 'the godfather') {
        switch (day.toLowerCase()) {
            case 'monday':
                return 12;
            case 'tuesday':
                return 10;
            case 'wednesday':
                return 15;
            case 'thursday':
                return 12.50;
            case 'friday':
                return 15;
            case 'saturday':
                return 25;
            case 'sunday':
                return 30;
            default:
                return 'error';
        }
    } else if (title.toLowerCase() === 'schindler\'s list') {
        switch (day.toLowerCase()) {
            case 'monday':
            case 'tuesday':
            case 'wednesday':
            case 'thursday':
            case 'friday':
                return 8.50;
            case 'saturday':
            case 'sunday':
                return 15;
            default:
                return 'error';
        }
    } else if (title.toLowerCase() === 'casablanca') {
        switch (day.toLowerCase()) {
            case 'monday':
            case 'tuesday':
            case 'wednesday':
            case 'thursday':
            case 'friday':
                return 8;
            case 'saturday':
            case 'sunday':
                return 10;
            default:
                return 'error';
        }
    } else if (title.toLowerCase() === 'the wizard of oz') {
        switch (day.toLowerCase()) {
            case 'monday':
            case 'tuesday':
            case 'wednesday':
            case 'thursday':
            case 'friday':
                return 10;
            case 'saturday':
            case 'sunday':
                return 15;
            default:
                return 'error';
        }
    }else{
        return 'error';
    }
}

calculateTicketPrice(['The Godfather', 'Friday']);
calculateTicketPrice(['casablanca', 'sunday']);
calculateTicketPrice(['Schindler\'s LIST', 'monday']);
calculateTicketPrice(['SoftUni', 'Nineday']);
