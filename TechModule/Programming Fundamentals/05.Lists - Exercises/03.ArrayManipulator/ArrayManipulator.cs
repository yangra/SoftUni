using System;
using System.Collections.Generic;
using System.Linq;

class ArrayManipulator
{
    static void Main()
    {
        List<int> nums = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

        string input = "";
        while (input != "print")
        {
            input = Console.ReadLine();
            string[] operation = input.Split(' ');
            PerformInstruction(operation, nums);
        }

    }

    public static void PerformInstruction(string[] operation, List<int> nums)
    {
        switch (operation[0])
        {
            case "add":
                {
                    int index = int.Parse(operation[1]);
                    int element = int.Parse(operation[2]);
                    AddAtIndex(index, element, nums);
                    break;
                }
            case "addMany":
                {
                    int index = int.Parse(operation[1]);
                    int[] elements = new int[operation.Length - 2];
                    for (int i = 2; i < operation.Length; i++)
                    {
                        elements[i - 2] = int.Parse(operation[i]);
                    }

                    AddManyAtIndex(index, elements, nums);
                    break;
                }
            case "contains":
                {
                    int element = int.Parse(operation[1]);
                    Contains(element, nums);
                    break;
                }
            case "remove":
                {
                    int index = int.Parse(operation[1]);
                    RemoveAtIndex(index, nums);
                    break;
                }
            case "shift":
                {
                    int positions = int.Parse(operation[1]);
                    ShiftLeft(positions, nums);
                    break;
                }
            case "sumPairs":
                {
                    SumPairs(nums);
                    break;
                }
            case "print":
                {
                    Print(nums);
                    break;
                }
            default:
                Console.WriteLine("Please enter a valid operation!");
                break;
        }
    }

    public static void Print(List<int> nums)
    {
        Console.WriteLine("[" + string.Join(", ", nums) + "]");
    }

    public static void SumPairs(List<int> nums)
    {
        for (int i = 0; i < nums.Count; i++)
        {
            if (i != nums.Count - 1)
            {
                nums[i] += nums[i + 1];
                nums.RemoveAt(i + 1);
            }
        }
    }

    public static void ShiftLeft(int positions, List<int> nums)
    {
        positions %= nums.Count;

        for (int i = 0; i < positions; i++)
        {
            int temp = nums[0];
            for (int j = 1; j < nums.Count; j++)
            {
                nums[j - 1] = nums[j];
            }
            nums[nums.Count - 1] = temp;
        }
    }

    public static void RemoveAtIndex(int index, List<int> nums)
    {
        nums.RemoveAt(index);
    }

    public static void Contains(int element, List<int> nums)
    {
        if (nums.Contains(element))
        {
            for (int i = 0; i < nums.Count; i++)
            {
                if (nums[i] == element)
                {
                    Console.WriteLine(i);
                    return;
                }
            }
        }

        Console.WriteLine(-1);
    }

    public static void AddManyAtIndex(int index, int[] elements, List<int> nums)
    {
        for (int i = 0; i < elements.Length; i++)
        {
            nums.Insert(index, elements[elements.Length - 1 - i]);
        }
    }

    public static void AddAtIndex(int index, int element, List<int> nums)
    {
        nums.Insert(index, element);
    }
}

