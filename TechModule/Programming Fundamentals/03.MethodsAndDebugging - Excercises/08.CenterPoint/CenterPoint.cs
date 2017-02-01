using System;

namespace MethodsAndDebugging
{
    public class CenterPoint
    {
        public static void Main(string[] args)
        {
            double x1 = double.Parse(Console.ReadLine());
            double y1 = double.Parse(Console.ReadLine());
            double x2 = double.Parse(Console.ReadLine());
            double y2 = double.Parse(Console.ReadLine());

            PrintThePointClosestToCenter(x1, y1, x2, y2);
        }

        public static void PrintThePointClosestToCenter(double XcoordPointOne, double YcoordPointOne, double XcoordPointTwo, double YcoordPointTwo)
        {
            double x1 = Math.Abs(XcoordPointOne);
            double y1 = Math.Abs(YcoordPointOne);
            double x2 = Math.Abs(XcoordPointTwo);
            double y2 = Math.Abs(YcoordPointTwo);

            if (x1 + y1 <= x2 + y2)
            { 
                Console.WriteLine("({0}, {1})", XcoordPointOne, YcoordPointOne);
            }
            else
            { 
                Console.WriteLine("({0}, {1})", XcoordPointTwo, YcoordPointTwo);
            }
        }
    }
}
