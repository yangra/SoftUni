using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.PrintingOnTheConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            var name = Console.ReadLine();
            var age = int.Parse(Console.ReadLine());
            var gender = char.Parse(Console.ReadLine());

            Console.WriteLine("Hello, "+ name);
            Console.WriteLine("Hello, {0}", name);
            Console.WriteLine("Hello, {0} you are {1} years old. Your gender is {2}", name, age, gender);
        }
    }
}
