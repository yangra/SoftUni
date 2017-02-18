using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Portal
{
    public class Portal
    {
        public static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            var map = new char[n][];
            var X = 0;
            var Y = 0;
            for (int row = 0; row < n; row++)
            {
                var line = Console.ReadLine();
                map[row] = line.ToCharArray();
                if (line.Contains('S'))
                {
                    X = row;
                    for (int i = 0; i < line.Length; i++)
                    {
                        if (line[i] == 'S')
                        {
                            Y = i;
                        }
                    }
                }
            }
            var moves = Console.ReadLine();
            for (int i = 0; i < moves.Length; i++)
            {
                MakeAMove(n, map, moves[i], ref X, ref Y);

                if (map[X][Y] == 'E')
                {
                    Console.WriteLine("Experiment successful. {0} turns required.", i + 1);
                    return;
                }
            }
            Console.WriteLine("Robot stuck at {0} {1}. Experiment failed.", X, Y);
        }

        public static void MakeAMove(int n, char[][] map, char move, ref int X, ref int Y)
        {
            switch (move)
            {
                case 'U':
                    if (X == 0)
                    {
                        X = n;
                    }
                    while (Y >= map[X - 1].Length)
                    {
                        if (X - 1 == 0)
                        {
                            X = n;
                        }
                        else
                        {
                            X--;
                        }
                    }
                    X--;
                    break;
                case 'D':
                    if (X == n - 1)
                    {
                        X = -1;
                    }
                    while (Y >= map[X + 1].Length)
                    {
                        if (X + 1 == n - 1)
                        {
                            X = -1;
                        }
                        else
                        {
                            X++;
                        }
                    }
                    X++;
                    break;
                case 'R':
                    if (Y + 1 < map[X].Length)
                    {
                        Y++;
                    }
                    else
                    {
                        Y = 0;
                    }
                    break;
                case 'L':
                    if (Y - 1 >= 0)
                    {
                        Y--;
                    }
                    else
                    {
                        Y = map[X].Length - 1;
                    }
                    break;
            }
        }

    }
}
