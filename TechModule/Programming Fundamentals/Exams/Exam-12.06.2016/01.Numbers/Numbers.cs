using System;
using System.Linq;

namespace _01.Numbers
{
    public class Numbers
    {
        public static void Main()
        {
            var numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            var topFive = numbers.Where(n => n > numbers.Average()).OrderByDescending(n => n).Take(5).ToArray();

            if (topFive.Length < 1)
            {
                Console.WriteLine("No");
            }
            else
            {
                Console.WriteLine(string.Join(" ", topFive));
            }
        }
    }
}
