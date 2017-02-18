using System;
using System.Linq;

namespace _04.ArrayModifier
{
    public class ArrayModifier
    {
        public static void Main()
        {
            var array = Console.ReadLine().Split().Select(long.Parse).ToArray();
            var command = Console.ReadLine();
            while (!command.Equals("end"))
            {
                ExecuteCommand(command,array);
                command = Console.ReadLine();
            }
            Console.WriteLine(string.Join(", ", array));
        }

        public static void ExecuteCommand(string command, long[] array)
        {
            var args = command.Split();
            switch (args[0])
            {
                case "swap":
                    {
                        var index1 = int.Parse(args[1]);
                        var index2 = int.Parse(args[2]);
                        Swap(index1, index2, array);
                        break;
                    }
                case "multiply":
                    {
                        var index1 = int.Parse(args[1]);
                        var index2 = int.Parse(args[2]);
                        Multiply(index1, index2, array);
                        break;
                    }
                case "decrease":
                    Decrease(array);
                    break;
                default:
                    break;
            }
        }

        public static void Decrease(long[] array)
        {
            for (int i = 0; i < array.Length; i++)
            {
                array[i] -= 1;
            }
        }

        public static void Multiply(int index1, int index2, long[] array)
        {
            array[index1] *= array[index2];
        }

        public static void Swap(int index1, int index2, long[] array)
        {
            var temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
    }
}
