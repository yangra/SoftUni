using System;

namespace _01.VolleyBall
{
    class Program
    {
        static void Main(string[] args)
        {
            string year = Console.ReadLine();
            int holidays = int.Parse(Console.ReadLine());
            int weekHome = int.Parse(Console.ReadLine());

            double plays = weekHome + (48 - weekHome) * (double)3 / 4 + holidays * (double)2 / 3;
            if (year=="leap")
            {
                plays *= 1.15;
            }
            Console.WriteLine(Math.Floor(plays));
        }
    }
}
