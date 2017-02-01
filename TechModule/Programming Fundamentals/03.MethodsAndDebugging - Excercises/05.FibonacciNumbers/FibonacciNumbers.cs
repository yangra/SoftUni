using System;

namespace MethodsAndDebugging
{
    public class FibonacciNumbers
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            long fibNum = Fib(n);
            Console.WriteLine(fibNum);
        }

        public static long Fib(int n)
        {
            long fib1 = 1;
            long fib2 = 1;
            long result = 1;
            for (int i = 1; i < n; i++)
            {
                result = fib1 + fib2;
                fib1 = fib2;
                fib2 = result;
            }
            return result;
        }
    }
}
