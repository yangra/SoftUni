using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExcellentCheck
{
    class Program
    {
        static void Main(string[] args)
        {
            double mark = double.Parse(Console.ReadLine());

            if(mark>=5.5&&mark<=6)
            {
                Console.WriteLine("Excellent!");
            }
        }
    }
}
