using System;

namespace MethodsAndDebugging
{
    class GeometryCalculator
    {
        public static void Main(string[] args)
        {
            string typeOfFigure = Console.ReadLine();
            double area = 0;
            switch (typeOfFigure)
            {
                case "triangle":
                    {
                        double side = double.Parse(Console.ReadLine());
                        double height = double.Parse(Console.ReadLine());
                        area = FindAreaOfTriangle(side, height);
                        break;
                    }
                case "rectangle":
                    {
                        double width = double.Parse(Console.ReadLine());
                        double height = double.Parse(Console.ReadLine());
                        area = FindAreaOfRectangle(width, height);
                        break;
                    }
                case "circle":
                    {
                        double radius = double.Parse(Console.ReadLine());
                        area = FindAreaOfCircle(radius);
                        break;
                    }
                case "square":
                    {
                        double side = double.Parse(Console.ReadLine());
                        area = FindAreaOfSquare(side);
                        break;
                    }
                default:
                    Console.WriteLine("Please spcify a type of figure!");
                    break;
            }

            Console.WriteLine("{0:F2}", area);
        }

        public static double FindAreaOfTriangle(double side, double height)
        {
            return (side * height) / 2;
        }

        static double FindAreaOfRectangle(double width, double height)
        {
            return width * height;
        }

        static double FindAreaOfCircle(double radius)
        {
            return Math.PI * Math.Pow(radius, 2);
        }

        static double FindAreaOfSquare(double side)
        {
            return side * side;
        }
    }
}
