using System;


namespace _02.BiggestTriple
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string[] numbers = input.Split(' ');
            int maxSum = Int32.MinValue;
            int index = 0;
            int start = 0;
            while (index < numbers.Length) 
            {
                int num1 = int.Parse(numbers[index]);
                int num2 = 0;
                if (index + 1 < numbers.Length)
                {
                    num2 = int.Parse(numbers[index + 1]);
                }
                int num3 = 0;
                if (index + 2 < numbers.Length)
                {
                    num3 = int.Parse(numbers[index + 2]);
                }
                int sum = num1 + num2 + num3;
                if (sum>maxSum)
                {
                    maxSum = sum;
                    start = index;
                }
                index = index + 3;
            }
            

            Console.Write(numbers[start]);
            start++;
            if (start<numbers.Length)
            {
                Console.Write(" ");
                Console.Write(numbers[start]);
            }
            start++;
            if (start < numbers.Length)
            {
                Console.Write(" ");
                Console.Write(numbers[start]);
            }

        }
    }
}
