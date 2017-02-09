using System;

namespace _03.CirclesIntersection
{
    public class CirclesIntersection
    {
        public static void Main()
        {
            Circle firstCircle = ReadCircle();
            Circle secondCircle = ReadCircle();
            if(Intersect(firstCircle,secondCircle))
            {
                Console.WriteLine("Yes");
            }
            else
            {
                Console.WriteLine("No");
            }
            
            

        }

        public static Circle ReadCircle()
        {
            var input = Console.ReadLine().Split(' ');

            Circle circle = new Circle
            {
                Center = new Point
                {
                    X = int.Parse(input[0]),
                    Y = int.Parse(input[1])
                },
                Radius = int.Parse(input[2])

            };

            return circle;
        }

        public static double DistancebetweenPoints(Point a, Point b)
        {
            var deltaX = a.X - b.X;
            var deltaY = a.Y - b.Y;
            return Math.Sqrt(deltaX * deltaX + deltaY * deltaY);
        }

        public static bool Intersect(Circle c1, Circle c2)
        {
            var distance = DistancebetweenPoints(c1.Center, c2.Center);
            if (distance<=c1.Radius+c2.Radius)
            {
                return true;
            }

            return false;
        }
    }
}
