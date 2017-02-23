using System;
using System.Linq;

namespace _02.LadyBugs
{
    class LadyBugs
    {
        static void Main()
        {
            var size = int.Parse(Console.ReadLine());
            var field = new int[size];
            var indexes = Console.ReadLine().Split().Select(int.Parse).ToArray();
            for (int i = 0; i < indexes.Length; i++)
            {
                if (indexes[i] >= 0 && indexes[i] < field.Length)
                {
                    field[indexes[i]] = 1;
                }
            }
            var move = Console.ReadLine();
            while (!move.Equals("end"))
            {
                var args = move.Split().ToArray();
                var index = int.Parse(args[0]);
                var direction = args[1];
                var flyLenght = int.Parse(args[2]);
                if (index >= 0 && index < field.Length && field[index] == 1)
                {
                    Fly(index, direction, flyLenght, field);
                }
                move = Console.ReadLine();
            }

            Console.WriteLine(string.Join(" ", field));
        }

        public static void Fly(int index, string direction, int flyLength, int[] field)
        {
            field[index] = 0;
            if (direction.Equals("right") && flyLength != 0)
            {
                index += flyLength;
                while (index >= 0 && index < field.Length && field[index] == 1)
                {
                    index += flyLength;
                }
                if (index < field.Length && index >= 0)
                {
                    field[index] = 1;
                }

            }
            else if (direction.Equals("left") && flyLength != 0)
            {
                index -= flyLength;
                while (index >= 0 && index < field.Length && field[index] == 1)
                {
                    index -= flyLength;
                }
                if (index < field.Length && index >= 0)
                {
                    field[index] = 1;
                }
            }
            else if (flyLength==0)
            {
                field[index] = 1;
            }
        }
    }
}
