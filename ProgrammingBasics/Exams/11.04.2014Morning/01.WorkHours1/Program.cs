using System;


namespace _01.WorkHours1
{
    class Program
    {
        static void Main(string[] args)
        {
            int h = int.Parse(Console.ReadLine());
            int d = int.Parse(Console.ReadLine());
            int p = int.Parse(Console.ReadLine());

            double effWork = Math.Floor(0.9 * d * 12 * p/100);
            if (effWork>=h)
            {
                Console.WriteLine("Yes");
                Console.WriteLine(effWork-h);
            }
            else
            {
                Console.WriteLine("No");
                Console.WriteLine(effWork-h);
            }
        }
    }
}
