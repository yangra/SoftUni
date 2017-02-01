using System;
using System.Linq;

class ArrayManipulator1
{
    static void Main()
    {
        int[] nums = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

        string input = "";
        while (input != "print")
        {
            input = Console.ReadLine();
            string[] operation = input.Split(' ');
            nums = PerformInstruction(operation, nums);
        }

    }

    public static int[] PerformInstruction(string[] operation, int[] nums)
    {
        switch (operation[0])
        {
            case "add":
                {
                    int index = int.Parse(operation[1]);
                    int element = int.Parse(operation[2]);
                    nums = AddAtIndex(index, element, nums);
                    return nums;
                }
            case "addMany":
                {
                    int index = int.Parse(operation[1]);
                    int[] elements = new int[operation.Length - 2];
                    for (int i = 2; i < operation.Length; i++)
                    {
                        elements[i - 2] = int.Parse(operation[i]);
                    }

                    nums = AddManyAtIndex(index, elements, nums);
                    return nums;
                }
            case "contains":
                {
                    int element = int.Parse(operation[1]);
                    Contains(element, nums);
                    return nums; 
                }
            case "remove":
                {
                    int index = int.Parse(operation[1]);
                    nums = RemoveAtIndex(index, nums);
                    return nums;
                }
            case "shift":
                {
                    int positions = int.Parse(operation[1]);
                    ShiftLeft(positions, nums);
                    return nums;
                }
            case "sumPairs":
                {
                    nums = SumPairs(nums);
                    return nums;
                }
            case "print":
                {
                    Print(nums);
                    return nums;
                }
            default:
                Console.WriteLine("Please enter a valid operation!");
                return nums;
        }
    }

    public static void Print(int[] nums)
    {
        Console.WriteLine("[" + string.Join(", ", nums) + "]");
    }

    public static int[] SumPairs(int[] nums)
    {
        for (int i = 0; i < nums.Length; i++)
        {
            if (i != nums.Length - 1)
            {
                nums[i] += nums[i + 1];
                nums = RemoveAtIndex(i + 1, nums);
            }
        }

        return nums;
    }

    public static void ShiftLeft(int positions, int[] nums)
    {
        positions %= nums.Length;

        for (int i = 0; i < positions; i++)
        {
            int temp = nums[0];
            for (int j = 1; j < nums.Length; j++)
            {
                nums[j - 1] = nums[j];
            }
            nums[nums.Length - 1] = temp;
        }
    }

    public static int[] RemoveAtIndex(int index, int[] nums)
    {
        int[] numsNew = new int[nums.Length - 1];
        for (int i = 0; i < index; i++)
        {
            numsNew[i] = nums[i];
        }
        for (int i = index + 1; i < nums.Length; i++)
        {
            numsNew[i - 1] = nums[i];
        }
        return numsNew;
    }

    public static void Contains(int element, int[] nums)
    {

        for (int i = 0; i < nums.Length; i++)
        {
            if (nums[i] == element)
            {
                Console.WriteLine(i);
                return;
            }
        }

        Console.WriteLine(-1);
    }

    public static int[] AddManyAtIndex(int index, int[] elements, int[] nums)
    {
        for (int i = 0; i < elements.Length; i++)
        {
            nums = AddAtIndex(index, elements[elements.Length - 1 - i], nums);
        }
        return nums;
    }

    public static int[] AddAtIndex(int index, int element, int[] nums)
    {
        int[] numsNew = new int[nums.Length + 1];
        for (int i = 0; i < index; i++)
        {
            numsNew[i] = nums[i];
        }
        numsNew[index] = element;
        for (int i = index + 1; i < numsNew.Length; i++)
        {
            numsNew[i] = nums[i-1];
        }
        return numsNew;
    }
}

