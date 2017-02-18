using System;
using System.Linq;

namespace _05.BlurFilter
{
    public class BlurFilter
    {
        public static void Main()
        {
            var blurAmount = int.Parse(Console.ReadLine());
            var sizes = Console.ReadLine().Split().Select(int.Parse).ToArray();
            var matrix = new long[sizes[0], sizes[1]];
            for (int row = 0; row < sizes[0]; row++)
            {
                var line = Console.ReadLine().Split().Select(long.Parse).ToArray();
                for (int col = 0; col < sizes[1]; col++)
                {
                    matrix[row, col] = line[col];
                }
            }

            var blurCenter = Console.ReadLine().Split().Select(int.Parse).ToArray();

            for (int row = blurCenter[0] - 1; row <= blurCenter[0] + 1; row++)
            {
                for (int col = blurCenter[1] - 1; col <= blurCenter[1] + 1; col++)
                {
                    if (row >= 0 && row < matrix.GetLength(0) && col >= 0 && col < matrix.GetLength(1))
                    {
                        matrix[row, col] += blurAmount;
                    }
                }
            }

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
