using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.DistanceBetweenPoints
{
    public class DistanceBetweenPoints
    {
        public static void Main()
        {
            Point firstPoint = ReadPoint();
            Point secondPoint = ReadPoint();

            var distance = CalculateDistance(firstPoint, secondPoint);

            Console.WriteLine($"{distance:F3}");
        }

        public static Point ReadPoint()
        {
            var pointArgs = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            var point = new Point
            {
                X = pointArgs[0],
                Y = pointArgs[1]
            };

            return point;
        }

        public static double CalculateDistance(Point firstPoint, Point secondPoint)
        {
            int deltaX = firstPoint.X - secondPoint.X;
            int deltaY = firstPoint.Y - secondPoint.Y;
            return Math.Sqrt(deltaX * deltaX + deltaY * deltaY);
        }
    }

}
