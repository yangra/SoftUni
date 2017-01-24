using System;

namespace _09.SpecialNumsRef
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
             
            for (int num = 1; num <= n; num++)
            {
                int sum = 0;
                int number = num;
                while (num > 0)
                {
                    sum += num % 10;
                    num = num / 10;
                }
                bool isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
                Console.WriteLine($"{number} -> {isSpecial}");
                num = number;
            }

        }
    }
}
