using System;
using System.Collections.Generic;
using System.Linq;

namespace _05.BombNumbers
{
    class BombNumbers
    {
        static void Main()
        {
            List<int> sequence = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            int[] bomb = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            while (sequence.Contains(bomb[0]))
            {
                for (int i = 0; i < sequence.Count; i++)
                {
                    if (sequence[i] == bomb[0])
                    {
                        for (int j = 0; j < bomb[1]; j++)
                        {
                            if (i + 1 < sequence.Count && i + 1 >= 0)
                            {
                                sequence.RemoveAt(i + 1);
                            }
                        }
                        sequence.Remove(bomb[0]);
                        for (int j = i - bomb[1]; j < i; j++)
                        {
                            if (i - bomb[1] >= 0)
                            {
                                sequence.RemoveAt(i - bomb[1]);
                            }
                            if (i - bomb[1] < 0 && i != 0 && j >= 0)
                            {
                                sequence.RemoveAt(0);
                            }
                        }

                        break;
                    }

                }
            }

            int sum = 0;
            foreach (var num in sequence)
            {
                sum += num;
            }

            Console.WriteLine(sum);
        }
    }
}
