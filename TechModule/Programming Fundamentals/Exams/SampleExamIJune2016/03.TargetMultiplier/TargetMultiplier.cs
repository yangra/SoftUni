using System;
using System.Linq;

namespace _03.TargetMultiplier
{
    public class TargetMultiplier
    {
        public static void Main()
        {
            var dimensions = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int[,] matrix = new int[dimensions[0], dimensions[1]];

            for (int i = 0; i < dimensions[0]; i++)
            {
                var row = Console.ReadLine().Split(' ');
                for (int j = 0; j < dimensions[1]; j++)
                {
                    matrix[i, j] = int.Parse(row[j]);
                }
            }

            var target = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int sumNeibours = 0;
            int targetValue = matrix[target[0], target[1]];
            for (int row = target[0] - 1; row <= target[0] + 1; row++)
            {
                for (int col = target[1] - 1; col <= target[1] + 1; col++)
                {
                    if (col >= 0 && col < dimensions[1] && row >= 0 && row < dimensions[0] )
                    {
                        if (row == target[0] &&col == target[1])
                        {
                            continue;
                        }

                        sumNeibours += matrix[row, col];
                        matrix[row, col] *= targetValue;
                    }
                }
            }

            matrix[target[0], target[1]] *= sumNeibours;

            for (int row = 0; row < dimensions[0]; row++)
            {
                for (int col = 0; col < dimensions[1]; col++)
                {
                    Console.Write("{0} ", matrix[row, col]);
                }
                Console.WriteLine();
            }
        }
    }
}
