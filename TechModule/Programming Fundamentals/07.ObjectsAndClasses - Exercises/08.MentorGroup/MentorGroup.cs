using System;
using System.Collections.Generic;
using System.Linq;

namespace _08.MentorGroup
{
    public class MentorGroup
    {
        public static void Main()
        {
            var students = new List<Student>();
            var attendance = Console.ReadLine();
            while (attendance != "end of dates")
            {
                if (attendance.Contains(" "))
                {
                    var attendArgs = attendance.Split();
                    var name = attendArgs[0];
                    var dates = attendArgs[1].Split(',');
                    if (students.Any(s => s.Name == name))
                    {
                        Student student = students.Single(s => s.Name == name);
                        student.AddDates(dates);
                    }
                    else
                    {
                        Student student = new Student(name);
                        student.AddDates(dates);
                        students.Add(student);
                    }
                }

                else
                {
                    var name = attendance;
                    if (!students.Any(s => s.Name == name))
                    {
                        Student student = new Student(name);
                        students.Add(student);
                    }
                }

                attendance = Console.ReadLine();
            }

            var input = Console.ReadLine();
            while (input != "end of comments")
            {
                var commentArgs = input.Split('-');
                var name = commentArgs[0];
                var comment = commentArgs[1];
                if (students.Any(s => s.Name == name))
                {
                    Student student = students.Single(s => s.Name == name);
                    student.Comment.Add(comment);
                }

                input = Console.ReadLine();
            }

            foreach (var student in students)
            {
                student.DatesAttended = student.DatesAttended.OrderBy(d => d.Date).ToList();
            }
            students = students.OrderBy(s => s.Name).ToList();
            foreach (var student in students)
            {
                Console.WriteLine(student.Name);
                Console.WriteLine("Comments:");
                foreach (var comment in student.Comment)
                {
                    Console.WriteLine("- {0}", comment);
                }

                Console.WriteLine("Dates attended:");
                foreach (var date in student.DatesAttended)
                {
                    Console.WriteLine("-- {0:dd/MM/yyyy}", date);
                }
            }
        }
    }
}
