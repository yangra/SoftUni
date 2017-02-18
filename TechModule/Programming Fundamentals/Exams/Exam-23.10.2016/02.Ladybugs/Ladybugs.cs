using System;
using System.Linq;
using System.Diagnostics;

namespace _02.Ladybugs
{
    public class Ladybugs
    {
        public static void Main()
        {
            int size = int.Parse(Console.ReadLine());
            var field = new int[size];
            int[] ladybugs = Console.ReadLine().Split().Select(int.Parse).ToArray();
            for (int i = 0; i < ladybugs.Length; i++)
            {
                if (ladybugs[i] >= 0 && ladybugs[i] < field.Length)
                {
                    field[ladybugs[i]] = 1;
                }
            }
            var command = Console.ReadLine();
            while (command != "end")
            {
                var args = command.Split();
                var index = int.Parse(args[0]);
                var direction = args[1];
                var flyLength = int.Parse(args[2]);
                if (index >= 0 && index < size && field[index] == 1)
                {
                    Fly(index, flyLength, direction, field);
                }
                command = Console.ReadLine();
            }

            Console.WriteLine(string.Join(" ", field));

        }

        private static void Fly(int index, int flyLength, string direction, int[] field)
        {
            if (direction == "right" && flyLength != 0)
            {
                int newIndex = index + flyLength;
                while (newIndex >= 0 && newIndex < field.Length && field[newIndex] == 1)
                {
                    newIndex += flyLength;
                }

                if (newIndex >= 0 && newIndex < field.Length)
                {
                    field[newIndex] = 1;
                    field[index] = 0;
                }
                else
                {
                    field[index] = 0;
                }

            }
            else if (direction == "left" && flyLength != 0)
            {
                var newIndex = index - flyLength;
                while (newIndex >= 0 && newIndex < field.Length && field[newIndex] == 1)
                {
                    newIndex -= flyLength;
                }

                if (newIndex >= 0 && newIndex < field.Length)
                {
                    field[newIndex] = 1;
                    field[index] = 0;
                }
                else
                {
                    field[index] = 0;
                }
            }
        }
    }
}
