using System;

namespace _01.StudyHall
{
    class Program
    {
        static void Main(string[] args)
        {
            double height = double.Parse(Console.ReadLine());
            double width = double.Parse(Console.ReadLine());

            var hcm = height * 100;
            var wcm = width * 100;
            var col = (int)(wcm-100) / 70;
            var row = (int)hcm / 120;
            var workPlaces = row * col - 3;
            Console.WriteLine(workPlaces);
        }
    }
}
