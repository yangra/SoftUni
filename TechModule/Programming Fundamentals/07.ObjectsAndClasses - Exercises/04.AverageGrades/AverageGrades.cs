using System;
using System.Collections.Generic;
using System.Linq;

namespace _04.AverageGrades
{
    class AverageGrades
    {
        static void Main()
        {
            int numberOfStudents = int.Parse(Console.ReadLine());
            List<Student> students = new List<Student>();
            for (int i = 0; i < numberOfStudents; i++)
            {
                var inputArgs = Console.ReadLine().Split(' ');
                Student student = new Student();
                ReadStudent(student, inputArgs);
                students.Add(student);
            }

            var topStudents = students.Where(s => s.AverageGrade >= 5).OrderBy(s => s.Name).ThenByDescending(s => s.AverageGrade);

            foreach (var student in topStudents)
            {
                Console.WriteLine($"{student.Name} -> {student.AverageGrade:F2}");
            }
        }

        private static void ReadStudent(Student student, string[] input)
        { 
            student.Name = input[0];
            student.Grades = input.Skip(1).Select(double.Parse).ToList();
            //for (int i = 1; i < inputArgs.Length; i++)
            //{
            //    student.Grades.Add(double.Parse(inputArgs[i]));
            //}
        }
    }
}
