using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.TriangleArea
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = decimal.Parse(Console.ReadLine());
            var ha = decimal.Parse(Console.ReadLine());

            var area = (a * ha) / 2;
            var areaRounded = Math.Round(area, 2);
            Console.WriteLine("Triangle area = {0}", areaRounded);
        }
    }
}
