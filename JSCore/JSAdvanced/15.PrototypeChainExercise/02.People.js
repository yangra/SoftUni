function solve() {
    class Employee {
        constructor(name, age) {
            if (new.target === Employee) {
                throw new TypeError();
            }
            this.name = name;
            this.age = age;
            this.salary = 0;
            this.tasks = [];
        }

        set _salary(salary){
            this.salary = salary;
        }

        work() {
            let task = this.tasks.shift();
            console.log(task);
            this.tasks.push(task);
        }

        collectSalary() {
            console.log(`${this.name} received ${this.getSalary()} this month.`);
        }

        getSalary() {
            return this.salary;
        }
    }

    class Junior extends Employee {
        constructor(name, age) {
            super(name, age);
            this.fillTasks();
        }


        fillTasks() {
            this.tasks.push(`${this.name} is working on a simple task.`);
        }
    }

    class Senior extends Employee {
        constructor(name, age) {
            super(name, age);
            this.fillTasks();
        }


        fillTasks() {
            this.tasks.push(`${this.name} is working on a complicated task.`);
            this.tasks.push(`${this.name} is taking time off work.`);
            this.tasks.push(`${this.name} is supervising junior workers.`);
        }
    }

    class Manager extends Employee {
        constructor(name, age) {
            super(name, age);
            this.dividend = 0;
            this.fillTasks();

        }

        set _dividend(dividend){
            this.dividend = dividend;
        }

        fillTasks() {
            this.tasks.push(`${this.name} scheduled a meeting.`);
            this.tasks.push(`${this.name} is preparing a quarterly report.`);
        }

        getSalary() {
            return this.salary + this.dividend;
        }
    }

    let man = new Manager("pesho",12);
    console.log(man.hasOwnProperty('salary'));

    return {Employee, Junior, Senior, Manager};
}

solve();