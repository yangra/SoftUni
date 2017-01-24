using System;

namespace _05.CalculateTriangleArea
{
    class CalculateTriangleArea
    {
        static void Main(string[] args)
        {
            double triangleBase = double.Parse(Console.ReadLine());
            double triangleHeight = double.Parse(Console.ReadLine());
            double triangleArea = GetTriangleArea(triangleBase,triangleHeight);
            Console.WriteLine(triangleArea);
        }

        static double GetTriangleArea(double side, double height)
        {
            double area = (side*height)/ 2;
            return area;
        }
    }
}
