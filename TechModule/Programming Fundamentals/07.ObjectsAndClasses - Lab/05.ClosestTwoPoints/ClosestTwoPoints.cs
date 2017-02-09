using System;
using System.Collections.Generic;
using System.Linq;

namespace _05.ClosestTwoPoints
{
    public class ClosestTwoPoints
    {
        public static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            var points = new List<Point>();
            for (int i = 0; i < n; i++)
            {
                var currentPoint = ReadPoint();
                points.Add(currentPoint);
            }

            var minDistance = double.MaxValue;
            Point firstPointMin = null;
            Point secondPointMin = null;
            for (int i = 0; i < points.Count-1; i++)
            {
                for (int j = i+1; j < points.Count; j++)
                {
                    var distance = CalculateDistance(points[i], points[j]);

                    if (minDistance > distance)
                    {
                        minDistance = distance;
                        firstPointMin = points[i];
                        secondPointMin = points[j];
                    }
                }
            }

            Console.WriteLine($"{minDistance:F3}");
            Console.WriteLine($"({firstPointMin.X}, {firstPointMin.Y})");
            Console.WriteLine($"({secondPointMin.X}, {secondPointMin.Y})");
        }

        private static Point ReadPoint()
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
