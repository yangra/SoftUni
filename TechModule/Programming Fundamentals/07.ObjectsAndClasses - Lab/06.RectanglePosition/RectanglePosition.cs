using System;
using System.Linq;


namespace _06.RectanglePosition
{
    public class RectanglePosition
    {
        public static void Main()
        {
            Rectangle firstRectangle = ReadRectangle();
            Rectangle secondRectangle = ReadRectangle();

            bool isInside = IsInside(firstRectangle, secondRectangle);
            if (isInside)
            {
                Console.WriteLine("Inside");
            }
            else
            {
                Console.WriteLine("Not inside");
            }

        }

        private static bool IsInside(Rectangle firstRectangle, Rectangle secondRectangle)
        {
            if (firstRectangle.Left >= secondRectangle.Left &&
                firstRectangle.Top <= secondRectangle.Top &&
                firstRectangle.Right <= secondRectangle.Right &&
                firstRectangle.Bottom >= secondRectangle.Bottom)
            {
                return true;
            }

            return false;
        }

        public static Rectangle ReadRectangle()
        {
            var rectangleArgs = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            var rectangle = new Rectangle
            {
                Left = rectangleArgs[0],
                Top = rectangleArgs[1],
                Width = rectangleArgs[2],
                Height = rectangleArgs[3]
            };

            return rectangle;
        }
    }
}
