using System;

namespace _07.LeftRightSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());

            int sumLeft = 0;
            int sumRight = 0;

            for (int i = 0; i < count; i++)
            {
                sumLeft += int.Parse(Console.ReadLine());
            }
            for (int i = 0; i < count; i++)
            {
                sumRight += int.Parse(Console.ReadLine());
            }

            if (sumLeft==sumRight)
            {
                Console.WriteLine("Yes, sum = {0}",sumRight);
            }
            else
            {
                Console.WriteLine("No, diff = {0}", Math.Abs(sumLeft-sumRight));
            }
        }
    }
}
