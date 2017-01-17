using System;

namespace _06.Battles
{
    class Program
    {
        static void Main(string[] args)
        {
            int player1 = int.Parse(Console.ReadLine());
            int player2 = int.Parse(Console.ReadLine());
            int maxBattles = int.Parse(Console.ReadLine());

            int counter = 0;
            for (int i = 1; i <= player1; i++)
            {
                for (int j = 1; j <= player2; j++)
                {
                    if (counter>=maxBattles)
                    {
                        break;
                    }
                    Console.Write("({0} <-> {1}) ", i, j);
                    counter++;
                }
                if (counter > maxBattles)
                {
                    break;
                }
            }
        }
    }
}
