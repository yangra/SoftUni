using System;


namespace _01.Problem1
{
    class Program
    {
        static void Main(string[] args)
        {
            double speed = double.Parse(Console.ReadLine());
            double firstPeriod = double.Parse(Console.ReadLine());
            double secondPeriod = double.Parse(Console.ReadLine());
            double thirdPeriod = double.Parse(Console.ReadLine());

            double secSpeed = speed * 1.1;
            double thirdSpeed = secSpeed * 0.95;

            double distance = (firstPeriod / 60) * speed + (secondPeriod / 60) * secSpeed + (thirdPeriod / 60) * thirdSpeed;

            Console.WriteLine("{0:F2}",distance);

        }
    }
}
