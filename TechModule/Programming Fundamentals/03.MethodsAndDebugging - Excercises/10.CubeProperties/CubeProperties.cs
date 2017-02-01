using System;

namespace MethodsAndDebugging
{
    public class CubeProperties
    {
        public static void Main(string[] args)
        {
            double side = double.Parse(Console.ReadLine());
            string find = Console.ReadLine();

            double result = 0;
            if (find == "face")
            {
                result = FindFaceDiagonal(side);
            }
            else if (find == "space")
            {
                result = FindSpaceDiagonal(side);
            }
            else if (find == "volume")
            {
                result = FindVolume(side);
            }
            else if (find == "area")
            {
                result = FindArea(side);
            }

            Print(result);

        }

        public static double FindArea(double side)
        {
            return 6 * Power(side, 2);
        }

        public static double FindVolume(double side)
        {
            return Power(side, 3);
        }

        public static double FindSpaceDiagonal(double side)
        {
            return Math.Sqrt(3 * Power(side, 2));
        }

        public static double FindFaceDiagonal(double side)
        {
            return Math.Sqrt(2 * Power(side, 2));
        }

        public static double Power(double number, int power)
        {
            double result = 1;
            for (int i = 0; i < power; i++)
            {
                result *= number;
            }
            return result;
        }

        public static void Print(double result)
        {
            Console.WriteLine("{0:F2}", result);
        }
    }
}
