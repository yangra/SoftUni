function sortTickets(data, criteria) {
    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }

        toString() {
            return `Ticket { destination: '${this.destination}',
    price: ${this.price},
    status: '${this.status}' }`
        }
    }

    let tickets = [];
    for (let str of data) {
        let params = str.split('\|');
        let ticket = new Ticket(params[0], Number(params[1]), params[2]);
        tickets.push(ticket)
    }

    let compare = {
        destination: (a, b) => a.destination.localeCompare(b.destination),
        price: (a, b) => a.price - b.price,
        status: (a, b) => a.status.localeCompare(b.status)
    };

    tickets.sort(compare[criteria]);
    return tickets;
}

sortTickets(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'],
    'destination');