using System;

namespace _11.EnterEvenNum
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = 0;
            while (true)
            {
                Console.Write("Enter even number: ");
                try
                {
                   n = int.Parse(Console.ReadLine());
                }
                catch (Exception)
                {
                    Console.WriteLine("Invalid number!");
                    continue;
                }
                if (n % 2 ==0)
                {
                    break;
                }
                else
                {
                    Console.WriteLine("The number is not even.");
                }
            }
            Console.WriteLine("Even number entered: {0}", n);
        }
    }
}
