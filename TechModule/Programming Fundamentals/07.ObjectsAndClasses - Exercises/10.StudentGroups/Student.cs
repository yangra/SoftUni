﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.StudentGroups
{
    public class Student
    {
        public string Name { get; set; }
        public string Town { get; set; }
        public string Email { get; set; }
        public DateTime RegistrationDate { get; set; }

        public Student(string name,string town, string email, DateTime date)
        {
            this.Name = name;
            this.Email = email;
            this.Town = town;
            this.RegistrationDate = date;

        }
    }
}
