using System;


namespace _04.Grades
{
    class Program
    {
        static void Main(string[] args)
        {
            int students = int.Parse(Console.ReadLine());

            double top = 0;
            double between45 = 0;
            double between34 = 0;
            double fail = 0;
            double allGrades = 0;

            for (int i = 0; i < students; i++)
            {
                double grade = double.Parse(Console.ReadLine());
                if (grade >= 5 && grade <= 6)
                {
                    top++;
                }
                else if (grade < 5 && grade >= 4)
                {
                    between45++;
                }
                else if (grade < 4 && grade >= 3)
                {
                    between34++;
                }
                else if (grade < 3)
                {
                    fail++;
                }

                allGrades += grade;
            }

            Console.WriteLine("Top students: {0:F2}%", (top/students)*100);
            Console.WriteLine("Between 4.00 and 4.99: {0:F2}%", (between45 / students)*100);
            Console.WriteLine("Between 3.00 and 3.99: {0:F2}%", (between34 / students)*100);
            Console.WriteLine("Fail: {0:F2}%", (fail / students)*100);
            Console.WriteLine("Average: {0:F2}", allGrades / students);
        }
    }
}
