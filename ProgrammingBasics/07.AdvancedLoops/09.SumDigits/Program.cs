using System;

namespace _09.SumDigits
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());

            int lastDigit = 0;
            int sum = 0;
            while(num>0)
            {
                lastDigit = num % 10;
                sum += lastDigit;
                num = num / 10;
            }
            Console.WriteLine(sum);
        }
    }
}
