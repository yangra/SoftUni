using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _13.AreaOfFigures
{
    class Program
    {
        static void Main(string[] args)
        {
            string figure = Console.ReadLine();
            double area = 0;

            switch (figure)
            {
                case "circle":
                    double radius = double.Parse(Console.ReadLine());
                    area = Math.PI * radius * radius;
                    Console.WriteLine(area);
                    break;
                case "rectangle":
                    double a = double.Parse(Console.ReadLine());
                    double b = double.Parse(Console.ReadLine());
                    area = a*b;
                    Console.WriteLine(area);
                    break;
                case "square":
                    double side = double.Parse(Console.ReadLine());
                    area = side * side;
                    Console.WriteLine(area);
                    break;
                case "triangle":
                    double sidea = double.Parse(Console.ReadLine());
                    double ha = double.Parse(Console.ReadLine());
                    area = (sidea * ha)/2;
                    Console.WriteLine(area);
                    break;
                default:
                    break;
            }
        }
    }
}
