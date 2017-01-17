using System;


namespace _05.Sequence2k_1
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int num = 1; num <= n; num = 2 * num + 1)
            {
                Console.WriteLine(num);
            }
        }
    }
}
