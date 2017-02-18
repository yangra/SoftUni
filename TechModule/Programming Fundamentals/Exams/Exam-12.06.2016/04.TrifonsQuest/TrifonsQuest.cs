using System;

namespace _04.TrifonsQuest
{
    public class TrifonsQuest
    {
        public static void Main()
        {

            long health = long.Parse(Console.ReadLine());
            var dims = Console.ReadLine().Split(' ');
            int rows = int.Parse(dims[0]);
            int cols = int.Parse(dims[1]);

            char[,] map = new char[rows, cols];
            for (int row = 0; row < rows; row++)
            {
                var currentRow = Console.ReadLine();
                for (int col = 0; col < cols; col++)
                {
                    map[row, col] = currentRow[col];
                }
            }

            int turns = 0;
            for (int col = 0; col < cols; col++)
            {
                if (col % 2 == 0)
                {
                    for (int row = 0; row < rows; row++)
                    {
                        health = MakeAMove(map[row, col], health, ref turns);
                        if (health <= 0)
                        {
                            Console.WriteLine($"Died at: [{row}, {col}]");
                            return;
                        }
                    }
                }
                else
                {
                    for (int row = rows - 1; row >= 0; row--)
                    {
                        health = MakeAMove(map[row, col], health, ref turns);
                        if (health <= 0)
                        {
                            Console.WriteLine($"Died at: [{row}, {col}]");
                            return;
                        }
                    }
                }
            }

            Console.WriteLine("Quest completed!");
            Console.WriteLine($"Health: {health}");
            Console.WriteLine($"Turns: {turns}");
        }

        private static long MakeAMove(char action, long health, ref int turns)
        {
            switch (action)
            {
                case 'F':
                    health -= turns / 2;
                    turns++;
                    return health;
                case 'H':
                    health += turns / 3;
                    turns++;
                    return health;
                case 'T':
                    turns += 3;
                    return health;
                case 'E':
                    turns++;
                    return health;
                default: return health;     
            } 
        }
    }
}
