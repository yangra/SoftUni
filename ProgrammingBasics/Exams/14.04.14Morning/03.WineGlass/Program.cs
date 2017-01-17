using System;

public class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());

        for (int i = 0; i < n / 2; i++)
        {
            Console.Write(new string('.', i));
            Console.Write("\\");
            Console.Write(new string('*', (n - 2) - (2 * i)));
            Console.Write("/");
            Console.Write(new string('.', i));
            Console.WriteLine();
        }

        if (n >= 12)
        {
            for (int i = 0; i < n / 2 - 2; i++)
            {
                Console.Write(new string('.', n / 2 - 1));
                Console.Write("||");
                Console.Write(new string('.', n / 2 - 1));
                Console.WriteLine();
            }

            for (int i = 0; i < 2; i++)
            {
                Console.Write(new string('-', n));
                Console.WriteLine();
            }

        }
        else
        {
            for (int i = 0; i < n / 2 - 1; i++)
            {
                Console.Write(new string('.', n / 2 - 1));
                Console.Write("||");
                Console.Write(new string('.', n / 2 - 1));
                Console.WriteLine();
            }
            Console.Write(new string('-', n));
        }
    }
}
