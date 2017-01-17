using System;

namespace _06.SpecialNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 1111; i <= 9999; i++)
            {
                int number = i;
                while (number!=0&&number%10!=0&&n%(number%10)==0)
                {
                    number /= 10;
                }
                if (number == 0)
                {
                    Console.Write("{0} ", i);
                }
            }
        }
    }
}
