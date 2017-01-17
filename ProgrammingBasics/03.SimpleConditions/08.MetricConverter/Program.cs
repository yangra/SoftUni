using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.MetricConverter
{
    class Program
    {
        static void Main(string[] args)
        {
            double value = double.Parse(Console.ReadLine());
            string input = Console.ReadLine();
            string output = Console.ReadLine();

            double coef1 = 0;
            double coef2 = 0;

            switch (input)
            {
                case "mm": coef1 = 1000;break;
                case "cm": coef1 = 100; break;
                case "mi": coef1 = 0.000621371192; break;
                case "in": coef1 = 39.3700787; break;
                case "km": coef1 = 0.001; break;
                case "ft": coef1 = 3.2808399; break;
                case "yd": coef1 = 1.0936133; break;
                case "m": coef1 = 1; break;
                default:break;
            }
            switch (output)
            {
                case "mm": coef2 = 1000; break;
                case "cm": coef2 = 100; break;
                case "mi": coef2 = 0.000621371192; break;
                case "in": coef2 = 39.3700787; break;
                case "km": coef2 = 0.001; break;
                case "ft": coef2 = 3.2808399; break;
                case "yd": coef2 = 1.0936133; break;
                case "m": coef2 = 1;break;
                default: break;
            }

            double answer = (value / coef1) * coef2;

            Console.WriteLine("{0} {1}",answer,output);
        }
    }
}
