using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.MultiplyTargetedCell
{
    public class MultiplyTargetedCell
    {
        public static void Main()
        {
            var sizes = Console.ReadLine().Split().Select(int.Parse).ToArray();
            var matrix = new int[sizes[0], sizes[1]];
            for (int row = 0; row < sizes[0]; row++)
            {
                var line = Console.ReadLine().Split().Select(int.Parse).ToArray();
                for (int col = 0; col < sizes[1]; col++)
                {
                    matrix[row, col] = line[col];
                }
            }

            var target = Console.ReadLine().Split().Select(int.Parse).ToArray();
            var surroundSum = 0;
            for (int row = target[0] - 1; row <= target[0] + 1; row++)
            {
                for (int col = target[1] - 1; col <= target[1] + 1; col++)
                {
                    if (!(row==target[0]&&col==target[1]))
                    {
                        surroundSum += matrix[row, col];
                        matrix[row, col] *= matrix[target[0], target[1]];
                    }

                }
            }

            matrix[target[0], target[1]] *= surroundSum;

            for (int row = 0; row < matrix.GetLength(0); row++)
            {
                for (int col = 0; col < matrix.GetLength(1); col++)
                {
                    Console.Write("{0} ", matrix[row, col]);
                }
                Console.WriteLine();
            }

        }
    }
}
