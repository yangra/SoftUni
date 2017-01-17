using System;

namespace _11.Cinema
{
    class Program
    {
        static void Main(string[] args)
        {
            string type = Console.ReadLine();
            int rows = int.Parse(Console.ReadLine());
            int cols = int.Parse(Console.ReadLine());

            switch (type)
            {
                case "Premiere": Console.WriteLine("{0:F2}",cols*rows*12); break;
                case "Normal": Console.WriteLine("{0:F2}", cols * rows * 7.5); break;
                case "Discount": Console.WriteLine("{0:F2}", cols * rows * 5); break;
                default:Console.WriteLine("Invalid type");break;
            }
        }
    }
}
