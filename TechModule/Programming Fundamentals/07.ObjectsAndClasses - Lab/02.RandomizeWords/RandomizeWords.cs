using System;

namespace _02.RandomizeWords
{
    public class RandomizeWords
    {
        public static void Main()
        {
            var words = Console.ReadLine().Split(' ');
            var random = new Random();
            for (int i = 0; i < words.Length; i++)
            {
                var randomIndex = random.Next(0, words.Length);
                var temporary = words[randomIndex];
                words[randomIndex] = words[i];
                words[i] = temporary;
            }

            foreach (var word in words)
            {
                Console.WriteLine("{0}", word);
            }
        }
    }
}
