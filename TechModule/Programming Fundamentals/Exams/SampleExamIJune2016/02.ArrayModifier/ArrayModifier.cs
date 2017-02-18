using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.ArrayModifier
{
    public class ArrayModifier
    {
        public static void Main()
        {
            var nums = Console.ReadLine().Split(' ').Select(long.Parse).ToArray();

            string[] command = Console.ReadLine().Split(' ');

            while (command[0] != "end")
            {
                ExecuteCommand(command, nums);
                command = Console.ReadLine().Split(' ');
            }

            Console.WriteLine(string.Join(", ", nums));
        }

        public static void ExecuteCommand(string[] command, long[] nums)
        {
            switch (command[0])
            {
                case "swap":
                    {
                        int firstIndex = int.Parse(command[1]);
                        int secondIndex = int.Parse(command[2]);
                        if (firstIndex >= 0 && firstIndex < nums.Length && 
                            secondIndex >= 0 && secondIndex < nums.Length)
                        {
                            long temp = nums[firstIndex];
                            nums[firstIndex] = nums[secondIndex];
                            nums[secondIndex] = temp;
                        }
                        break;
                    }
                case "multiply":
                    {
                        int firstIndex = int.Parse(command[1]);
                        int secondIndex = int.Parse(command[2]);
                        if (firstIndex >= 0 && firstIndex < nums.Length &&
                            secondIndex >= 0 && secondIndex < nums.Length)
                        {
                            nums[firstIndex] = nums[secondIndex]*nums[firstIndex];
                        }
                        break;
                    }
                case "decrease":
                    {
                        for (int i = 0; i < nums.Length; i++)
                        {
                            nums[i]--;
                        }
                        break;
                    }
                default:
                    break;
            }
        }
    }
}
