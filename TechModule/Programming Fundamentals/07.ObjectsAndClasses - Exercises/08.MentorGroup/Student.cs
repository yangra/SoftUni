using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.MentorGroup
{
    public class Student
    {
        public string Name { get; set; }
        public List<string> Comment { get; set; }
        public List<DateTime> DatesAttended { get; set; }

        public Student(string name)
        {
            this.Name = name;
            this.DatesAttended = new List<DateTime>();
            this.Comment = new List<string>();
        }

        public void AddDates(string[] dates)
        {
            for (int i = 0; i < dates.Length; i++)
            {
                this.DatesAttended.Add(DateTime.ParseExact(dates[i], "dd/MM/yyyy", CultureInfo.InvariantCulture));
            }
        }


    }
}
