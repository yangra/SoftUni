using System;
using System.Linq;

namespace _05.ShortWordsSorted
{
    class ShortWordsSorted
    {
        static void Main(string[] args)
        {
            char[] separators = new char[] { '.', ',', ':', ';', '(', ')', '[', ']', '"', '\'', '\\', '/', '!', '?', ' ' };
            string[] words = Console.ReadLine().ToLower().Split(separators, StringSplitOptions.RemoveEmptyEntries).ToArray();
            string[] result = words.Where(w => w.Length < 5).OrderBy(w => w).Distinct().ToArray();
            Console.WriteLine(string.Join(", ", result));
        }
    }
}
