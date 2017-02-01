using System;

namespace MethodsAndDebugging
{
    public class MaxMethod
    {
        public static void Main(string[] args)
        {
            int firstNum = int.Parse(Console.ReadLine());
            int secondNum = int.Parse(Console.ReadLine());
            int thirdNum = int.Parse(Console.ReadLine());

            int result = GetMax(firstNum, secondNum, thirdNum);
            Console.WriteLine(result);

        }

        public static int GetMax( int a, int b, int c)
        {
            return GetMax(GetMax(a, b), c);
        }

        public static int GetMax(int a, int b)
        {
            if (a >= b)
            { 
                return a;
            }

            return b;
        }
    }
}
