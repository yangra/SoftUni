using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.ArrayManipulatorLinQ
{
    public class ArrayManipulator
    {
        public static void Main()
        {
            var array = Console.ReadLine().Split().Select(int.Parse).ToArray();
            var input = Console.ReadLine();
            while (!input.Equals("end"))
            {
                var args = input.Split();
                ExecuteCommand(args, array);
                input = Console.ReadLine();
            }

            Console.WriteLine("[" + string.Join(", ", array) + "]");
        }

        public static void ExecuteCommand(string[] args, int[] array)
        {
            switch (args[0])
            {
                case "exchange":
                    {
                        var index = int.Parse(args[1]);
                        if (index >= array.Length || index < 0)
                        {
                            Console.WriteLine("Invalid index");
                            break;
                        }
                        ExchangeParts(index, array);
                        break;
                    }
                case "max":
                    {
                        var evenOdd = args[1];
                        if (evenOdd == "even")
                        {
                            ReturnMax(0, array);
                        }
                        else
                        {
                            ReturnMax(1, array);
                        }
                        break;
                    }
                case "min":
                    {
                        var evenOdd = args[1];
                        if (evenOdd == "even")
                        {
                            ReturnMin(0, array);
                        }
                        else
                        {
                            ReturnMin(1, array);
                        }
                        break;
                    }
                case "first":
                    {
                        int count = int.Parse(args[1]);
                        var evenOdd = args[2];
                        if (count > array.Length)
                        {
                            Console.WriteLine("Invalid count");
                            break;
                        }
                        if (evenOdd == "even")
                        {
                            FirstElements(count, 0, array);
                        }
                        else
                        {
                            FirstElements(count, 1, array);
                        }
                        break;
                    }
                case "last":
                    {
                        int count = int.Parse(args[1]);
                        var evenOdd = args[2];
                        if (count > array.Length)
                        {
                            Console.WriteLine("Invalid count");
                            break;
                        }
                        if (evenOdd == "even")
                        {
                            LastElements(count, 0, array);
                        }
                        else
                        {
                            LastElements(count, 1, array);
                        }
                        break;
                    }
            }
        }

        public static void LastElements(int count, int oddEven, int[] array)
        {
            var result = new List<int>();
            var res = array.Where(a => a % 2 == oddEven).ToArray();
            for (int i = res.Length - 1; count > 0 && i >= 0; i--)
            {
                result.Add(res[i]);
                count--;
            }
            result.Reverse();
            Console.WriteLine("[" + string.Join(", ", result) + "]");
        }

        public static void FirstElements(int count, int evenOdd, int[] array)
        {
            var result = new List<int>();
            for (int i = 0; i < array.Length; i++)
            {
                if (count == 0)
                {
                    break;
                }
                if (array[i] % 2 == evenOdd)
                {
                    result.Add(array[i]);
                    count--;
                }
            }
            Console.WriteLine("[" + string.Join(", ", result) + "]");
        }

        public static void ReturnMin(int evenOdd, int[] array)
        {
            var min = 2000;
            var index = -1;
            for (int i = array.Length - 1; i >= 0; i--)
            {
                if (array[i] % 2 == evenOdd)
                {
                    if (min > array[i])
                    {
                        min = array[i];
                        index = i;
                    }
                }
            }

            if (index != -1)
            {
                Console.WriteLine(index);
            }
            else
            {
                Console.WriteLine("No matches");
            }
        }

        public static void ReturnMax(int evenOdd, int[] array)
        {
            var max = -1;
            var index = -1;
            for (int i = array.Length - 1; i >= 0; i--)
            {
                if (array[i] % 2 == evenOdd)
                {
                    if (max < array[i])
                    {
                        max = array[i];
                        index = i;
                    }
                }
            }

            if (index != -1)
            {
                Console.WriteLine(index);
            }
            else
            {
                Console.WriteLine("No matches");
            }
        }

        public static void ExchangeParts(int index, int[] array)
        {
            var result = new List<int>();
            for (int i = index + 1; i < array.Length; i++)
            {
                result.Add(array[i]);
            }
            for (int i = 0; i <= index; i++)
            {
                result.Add(array[i]);
            }
            for (int i = 0; i < array.Length; i++)
            {
                array[i] = result[i];
            }
        }
    }
}

