using System;

namespace _04.DivisionNoRest
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            double divby4 = 0;
            double divby3 = 0;
            double divby2 = 0;

            for (int i = 0; i < n; i++)
            {
                int number = int.Parse(Console.ReadLine());
                if (number%2==0)
                {
                    divby2++;
                }
                if (number%3==0)
                {
                    divby3++;
                }
                if (number%4==0)
                {
                    divby4++;
                }
            }
            if (divby2!=0)
            {
                Console.WriteLine("{0:f2}%",divby2/n*100);
            }
            else
            {
                Console.WriteLine("0.00%");
            }
            if (divby3 != 0)
            {
                Console.WriteLine("{0:f2}%", divby3 / n * 100);
            }
            else
            {
                Console.WriteLine("0.00%");
            }
            if (divby4 != 0)
            {
                Console.WriteLine("{0:f2}%", divby4 / n * 100);
            }
            else
            {
                Console.WriteLine("0.00%");
            }
        }
    }
}
