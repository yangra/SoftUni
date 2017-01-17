using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _13.StudentHall
{
    class Program
    {
        static void Main(string[] args)
        {
            double x = double.Parse(Console.ReadLine());
            double y = double.Parse(Console.ReadLine());

            double xcm = x * 100;
            double ycm = y * 100;

            int count = (int)xcm / 120 * (((int)ycm - 100) / 70) - 3;
            Console.WriteLine(count);


        }
    }
}
