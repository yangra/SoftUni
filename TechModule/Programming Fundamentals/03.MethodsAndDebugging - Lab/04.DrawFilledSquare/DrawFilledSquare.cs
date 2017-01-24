using System;

namespace _04.DrawFilledSquare
{
    class DrawFilledSquare
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            PrintEnd(n);
            for (int i = 1; i < n-1; i++)
            {
                PrintMiddleRow(n);
            }
            PrintEnd(n);
        }

        private static void PrintMiddleRow(int n)
        {         
            Console.Write("-");
            for (int j = 1; j < n; j++)
            {
                Console.Write("\\/");
            }
            Console.WriteLine("-");
        }

        private static void PrintEnd(int n)
        {
            Console.WriteLine(new string('-',2*n));
        }
    }
}
