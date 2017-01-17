using System;


namespace _03.Arrow
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            Console.Write(new string('.', n / 2));
            Console.Write(new string('#', n));
            Console.WriteLine(new string('.', n / 2));
            for (int i = 0; i < n - 2; i++)
            {
                Console.Write(new string('.', n / 2));
                Console.Write("#");
                Console.Write(new string('.', n -2));
                Console.Write("#");
                Console.WriteLine(new string('.', n / 2));
            }

            Console.Write(new string('#', (n / 2)+1));
            Console.Write(new string('.', n - 2));
            Console.WriteLine(new string('#', (n / 2) + 1));

            for (int i = 1, j = n+2*(n/2)-4; i < n; i++,j-=2)
            {
                Console.Write(new string('.',i));
                Console.Write("#");
                if (j>=0)
                {
                    Console.Write(new string('.', j));
                }
                if (i!=n-1)
                {
                    Console.Write("#");
                }
                Console.WriteLine(new string('.', i));
            }
        }
    }
}
