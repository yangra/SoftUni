using System;

namespace _01.RectangleArea
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Enter first side: ");
            var firstSide = decimal.Parse(Console.ReadLine());
            Console.Write("Enter second side: ");
            var secondSide = decimal.Parse(Console.ReadLine());

            var area = firstSide * secondSide;
            Console.WriteLine("Area is: {0}", area);
            
        }
    }
}
