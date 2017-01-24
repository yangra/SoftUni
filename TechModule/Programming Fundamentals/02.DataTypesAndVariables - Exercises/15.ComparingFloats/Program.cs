using System;

namespace _15.ComparingFloats
{
    class Program
    {
        static void Main(string[] args)
        {
            double num1 = double.Parse(Console.ReadLine());
            double num2 = double.Parse(Console.ReadLine());

            bool comparison = Math.Abs(num1 - num2) < 0.000001;
            Console.WriteLine(comparison);
        }
    }
}
