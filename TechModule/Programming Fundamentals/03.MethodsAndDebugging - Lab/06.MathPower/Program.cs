using System;

namespace _06.MathPower
{
    class Program
    {
        static void Main(string[] args)
        {
            double number = double.Parse(Console.ReadLine());
            int power = int.Parse(Console.ReadLine());

            double answer = RaiseToPower(number, power);
            Console.WriteLine(answer);
        }

        static double RaiseToPower(double num, int pow)
        {
            double result = 1; 
            for (int i = 0; i < pow; i++)
            {
                result *= num;
            }
            return result;
        }
    }
}
