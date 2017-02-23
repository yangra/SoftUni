using System;
using System.Collections.Generic;
using System.Linq;

namespace _02.CommandInterpreter
{
    class CommandInterpreter
    {
        static void Main(string[] args)
        {
            var array = Console.ReadLine().Split(new char[] { ' ', '\t' }, StringSplitOptions.RemoveEmptyEntries).ToList();
            var line = Console.ReadLine();
            while (!line.Equals("end"))
            {
                var tokens = line.Split(' ');
                var command = tokens[0];
                switch (command)
                {
                    case "reverse":
                        {
                            var start = int.Parse(tokens[2]);
                            var count = int.Parse(tokens[4]);
                            if (start >= 0 && start < array.Count &&
                                count >= 0 && start + count <= array.Count)
                            {
                                Reverse(array, start, count);
                            }
                            else
                            {
                                Console.WriteLine("Invalid input parameters.");
                            }

                            break;
                        }
                    case "sort":
                        {
                            var start = int.Parse(tokens[2]);
                            var count = int.Parse(tokens[4]);
                            if (start >= 0 && start < array.Count &&
                                count >= 0 && start + count <= array.Count)
                            {
                                Sort(array, start, count);
                            }
                            else
                            {
                                Console.WriteLine("Invalid input parameters.");
                            }
                            break;
                        }
                    case "rollLeft":
                        {
                            var times = int.Parse(tokens[1]);
                            if (times >= 0)
                            {
                                RollLeft(array, times);
                            }
                            else
                            {
                                Console.WriteLine("Invalid input parameters.");
                            }

                            break;
                        }
                    case "rollRight":
                        {
                            var times = int.Parse(tokens[1]);
                            if (times>=0)
                            {
                                RollRight(array, times);
                            }
                            else
                            {
                                Console.WriteLine("Invalid input parameters.");
                            }
                           
                            break;
                        }
                }
                line = Console.ReadLine();
            }
            Console.WriteLine("[{0}]", string.Join(", ", array));
        }

        public static void RollRight(List<string> array, int times)
        {
            times = times % array.Count;
            for (int i = 0; i < times; i++)
            {
                var lastElem = array[array.Count - 1];
                array.RemoveAt(array.Count - 1);
                array.Insert(0, lastElem);
            }

        }

        public static void RollLeft(List<string> array, int times)
        {
            times = times % array.Count;
            for (int i = 0; i < times; i++)
            {
                var firstElem = array[0];
                for (int j = 0; j < array.Count - 1; j++)
                {
                    array[j] = array[j + 1];
                }
                array[array.Count - 1] = firstElem;
            }

        }

        public static void Sort(List<string> array, int start, int count)
        {
            var subarray = array.Skip(start).Take(count).ToList();
            subarray.Sort();
            array.RemoveRange(start, count);
            array.InsertRange(start, subarray);
        }

        public static void Reverse(List<string> array, int start, int count)
        {
            var subarray = array.Skip(start).Take(count).ToList();
            subarray.Reverse();
            array.RemoveRange(start, count);
            array.InsertRange(start, subarray);
        }
    }
}

