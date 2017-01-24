using System;

namespace _12.VowelOrDigit
{
    class Program
    {
        static void Main(string[] args)
        {
            char symbol = char.Parse(Console.ReadLine());

            if (symbol == 'a' || symbol == 'o' || symbol == 'e' || symbol == 'i' || symbol == 'u' || symbol == 'A' || symbol == 'O' || symbol == 'E' || symbol == 'I' || symbol == 'U')
            {
                Console.WriteLine("vowel");
            }
            else if (symbol >= '0' && symbol <= '9')
            {
                Console.WriteLine("digit");
            }
            else
            {
                Console.WriteLine("other");
            }
        }
    }
}
