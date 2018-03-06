function personAndTeacher(){
    class Person{
        constructor(name, email){
            this.name = name;
            this.email = email;
        }

        toString(){
            let className = this.constructor.name;
            return `${className} (name: ${this.name}, email: ${this.email})`;
        }
    }



    class Teacher extends Person{
        constructor(name, email, subject){
            super(name, email);
            this.subject = subject;
        }

        toString(){
            let parentStr = super.toString().slice(0, -1);
            return parentStr + `, subject: ${this.subject})`
        }
    }

    class Student extends Person {
        constructor(name, email, course){
            super(name, email);
            this.course = course;
        }

        toString(){
            let parentStr = super.toString().slice(0, -1);
            return parentStr + `, course: ${this.course})`
        }
    }

    return {Person, Teacher, Student}
}

let obj = personAndTeacher();
let Person = obj.Person;
let Teacher = obj.Teacher;
let Student = obj.Student;


let p = new Person('Gosho', 'gosho@abv.bg');
console.log(p.toString());
let t  = new Teacher ('Pesho', 'pesho@abv.bg', 'JavaScript');
console.log(t.toString());
let s  = new Student ('Stamat', 'stamat@abv.bg', 'JavaAdvanced');
console.log(s.toString());

