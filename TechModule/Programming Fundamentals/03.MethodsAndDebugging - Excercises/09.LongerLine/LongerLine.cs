using System;

namespace MethodsAndDebugging
{
    class LongerLine
    {
        public static void Main(string[] args)
        {
            double x1 = double.Parse(Console.ReadLine());
            double y1 = double.Parse(Console.ReadLine());
            double x2 = double.Parse(Console.ReadLine());
            double y2 = double.Parse(Console.ReadLine());
            double x3 = double.Parse(Console.ReadLine());
            double y3 = double.Parse(Console.ReadLine());
            double x4 = double.Parse(Console.ReadLine());
            double y4 = double.Parse(Console.ReadLine());

            double lengthOne = FindLengthOfLine(x1, y1, x2, y2);
            double lengthTwo = FindLengthOfLine(x3, y3, x4, y4);
            if (lengthOne >= lengthTwo)
            {
                PrintTheLine(x1, y1, x2, y2);
            }
            else
            {
                PrintTheLine(x3, y3, x4, y4);
            }
        }

        private static double FindLengthOfLine(double XcoordPointOne, double YcoordPointOne, double XcoordPointTwo, double YcoordPointTwo)
        {
            double length = 0;
            double sideA = Math.Abs(XcoordPointOne - XcoordPointTwo);
            double sideB = Math.Abs(YcoordPointOne - YcoordPointTwo);
            length = Math.Sqrt(sideA * sideA + sideB * sideB);
            return length;
        }

        static void PrintTheLine(double XcoordPointOne, double YcoordPointOne, double XcoordPointTwo, double YcoordPointTwo)
        {
            double x1 = Math.Abs(XcoordPointOne);
            double y1 = Math.Abs(YcoordPointOne);
            double x2 = Math.Abs(XcoordPointTwo);
            double y2 = Math.Abs(YcoordPointTwo);

            if (x1 + y1 <= x2 + y2)
                Console.WriteLine("({0}, {1})({2}, {3})", XcoordPointOne, YcoordPointOne, XcoordPointTwo, YcoordPointTwo);
            else
                Console.WriteLine("({0}, {1})({2}, {3})", XcoordPointTwo, YcoordPointTwo, XcoordPointOne, YcoordPointOne);
        }
    }
}
