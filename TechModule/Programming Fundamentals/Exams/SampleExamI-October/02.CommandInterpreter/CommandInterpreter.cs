using System;
using System.Collections.Generic;


namespace _02.CommandInterpreter
{
    public class CommandInterpreter
    {
        public static void Main()
        {
            var array = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            var input = Console.ReadLine();
            while (!input.Equals("end"))
            {
                var args = input.Split();
                try
                {
                    ExecuteCommand(args, array);
                }
                catch (FormatException)
                {
                    Console.WriteLine("Invalid input parameters.");
                }
                input = Console.ReadLine();
            }
            Print(array);
        }

        public static void Print(string[] array)
        {
            Console.WriteLine($"[{string.Join(", ", array)}]");
        }

        public static void ExecuteCommand(string[] args, string[] array)
        {
            switch (args[0])
            {
                case "reverse":
                    {
                        int start = int.Parse(args[2]);
                        int count = int.Parse(args[4]);
                        if (start < 0 || start > array.Length - 1 || count < 0 || count > array.Length || start + count > array.Length)
                        {
                            throw new FormatException();
                        }
                        Reverse(array, start, count);
                        break;
                    }
                case "sort":
                    {
                        int start = int.Parse(args[2]);
                        int count = int.Parse(args[4]);
                        if (start < 0 || start > array.Length - 1 || count < 0 || count > array.Length || start + count > array.Length)
                        {
                            throw new FormatException();
                        }
                        Sort(array, start, count);
                        break;
                    }
                case "rollLeft":
                    {
                        int times = int.Parse(args[1]);
                        if (times < 0)
                        {
                            throw new FormatException();
                        }
                        times = times % array.Length;
                        RollLeft(array, times);
                        break;
                    }
                case "rollRight":
                    {
                        int times = int.Parse(args[1]);
                        if (times < 0)
                        {
                            throw new FormatException();
                        }
                        times = times % array.Length;
                        RollRight(array, times);
                        break;
                    }
            }
        }

        private static void RollLeft(string[] array, int times)
        {
            for (int i = 0; i < times; i++)
            {
                var temp = array[0];
                for (int j = 0; j < array.Length - 1; j++)
                {
                    array[0 + j] = array[1 + j];
                }
                array[array.Length - 1] = temp;
            }
        }

        public static void RollRight(string[] array, int times)
        {
            for (int i = 0; i < times; i++)
            {
                var temp = array[array.Length - 1];
                for (int j = 0; j < array.Length - 1; j++)
                {
                    array[array.Length - 1 - j] = array[array.Length - 2 - j];
                }
                array[0] = temp;
            }
        }

        public static void Sort(string[] array, int start, int count)
        {
            var subarray = new List<string>();
            for (int i = start; i < start + count; i++)
            {
                subarray.Add(array[i]);
            }
            subarray.Sort();
            for (int i = start; i < start + count; i++)
            {
                array[i] = subarray[i - start];
            }
        }

        public static void Reverse(string[] array, int start, int count)
        {
            int j = 0;
            for (int i = start; i < start + count / 2; i++)
            {
                var temp = array[i];
                array[i] = array[start + count - 1 + j];
                array[start + count - 1 + j] = temp;
                j--;
            }
        }
    }
}
