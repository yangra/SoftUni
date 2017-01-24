using System;

namespace _05.SpecialNums
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 1; i <= n; i++)
            {
                bool isSpecial = false;
                int digSum = 0;
                int num = i;
                while (num!=0)
                {
                    digSum += num % 10;
                    num /= 10;
                }
                if (digSum == 5 || digSum == 7 || digSum == 11)
                    isSpecial = true;

                Console.WriteLine("{0} -> {1}",i,isSpecial);
            }
        }
    }
}
