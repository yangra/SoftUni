using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.SumSeconds
{
    class Program
    {
        static void Main(string[] args)
        {
            int num1 = int.Parse(Console.ReadLine());
            int num2 = int.Parse(Console.ReadLine());
            int num3 = int.Parse(Console.ReadLine());

            int sum = num1 + num2 + num3;

            int minutes = sum / 60;
            int seconds = sum % 60;

            Console.WriteLine("{0}:{1:00}",minutes,seconds);
        }
    }
}
