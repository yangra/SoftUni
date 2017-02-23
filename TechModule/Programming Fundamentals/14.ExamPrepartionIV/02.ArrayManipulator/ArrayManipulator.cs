using System;
using System.Linq;

namespace _02.ArrayManipulator
{
    class ArrayManipulator
    {
        static void Main()
        {
            var array = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();
            var line = Console.ReadLine();
            while (!line.Equals("end"))
            {
                var command = line.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

                switch (command[0])
                {
                    case "exchange":
                        array = Exchange(array, int.Parse(command[1]));
                        break;
                    case "max":
                    case "min":
                        MaxAndMin(array, command[0], command[1]);
                        break;
                    case "first": 
                    case "last":
                        FirstAndLast(array, command[0], int.Parse(command[1]), command[2]);
                        break;
                }
                line = Console.ReadLine();
            }

            Print(array);
        }

        private static void FirstAndLast(int[] array, string firstOrLast, int count, string evenOrOdd)
        {
            if (count>array.Length)
            {
                Console.WriteLine("Invalid count");
                return;
            }

            var filter = Filter(array, evenOrOdd);

            if (firstOrLast.Equals("first"))
            {
                var result = filter.Take(count).ToArray();
                Print(result);
            }
            else
            {
                var result = filter.Reverse().Take(count).Reverse().ToArray();
                Print(result);
            }
        }

        public static void MaxAndMin(int[] array, string maxOrMin, string evenOrOdd)
        {
            var filter = Filter(array,evenOrOdd);

            if (filter.Any())
            {
                if (maxOrMin.Equals("max"))
                {
                    var answer = filter.Max();
                    Console.WriteLine(Array.LastIndexOf(array, answer));
                }
                else
                {
                    var answer = filter.Min();
                    Console.WriteLine(Array.LastIndexOf(array, answer));
                }
            }Array.
            else
            {
                Console.WriteLine("No matches");
            }
        }

        private static int[] Exchange(int[] array, int index)
        {
            if (index < 0 || index >= array.Length)
            {
                Console.WriteLine("Invalid index");
                return array;
            }
            else
            {
                var subArrayOne = array.Take(index + 1);
                var subArrayTwo = array.Skip(index + 1);

                return subArrayTwo.Concat(subArrayOne).ToArray();
            }
        }

        public static int[] Filter(int[] array, string evenOrOdd)
        {
            return array.Where(e => evenOrOdd == "even" ? e % 2 == 0 : e % 2 == 1).ToArray();
        }

        public static void Print(int[] array)
        {
            Console.WriteLine("[{0}]", string.Join(", ", array));
        }
    }
}
