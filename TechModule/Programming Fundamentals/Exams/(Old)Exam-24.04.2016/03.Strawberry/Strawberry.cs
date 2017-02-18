using System;

namespace _03.Strawberry
{
    public class Strawberry
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n / 2; i++)
            {
                Console.WriteLine("{0}\\{1}|{1}/{0}", new string('-', i * 2), new string('-', n - i * 2));
            }

            for (int i = 0; i < n - n / 2 ; i++)
            {
                Console.WriteLine("{0}#{1}#{0}", new string('-', n-i*2), new string('.', i*4+1));
            }

            for (int i = 0; i < n+1; i++)
            {
                Console.WriteLine("{0}#{1}#{0}", new string('-', i), new string('.', 2*n+1-2*i));
            }

        }
    }
}
