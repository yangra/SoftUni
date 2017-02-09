using System;

namespace _02.AdvertisementMessage
{
    public class AdvertisementMessage
    {
        public static void Main(string[] args)
        {
            var phrases = new string[]
            {
                "Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."
            };

            var events = new string[]
            {
                "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"
            };

            var authors = new string[]
            {
                "Diana",
                "Petya",
                "Stella",
                "Elena",
                "Katya",
                "Iva",
                "Annie",
                "Eva"
            };

            var cities = new string[]
            {
                "Burgas",
                "Sofia",
                "Plovdiv",
                "Varna",
                "Ruse"
            };
            Random rand = new Random();

            int numberOfMessages = int.Parse(Console.ReadLine());
            for (int i = 0; i < numberOfMessages; i++)
            {
                var indexPhrase = rand.Next(0, phrases.Length);
                var indexEvent = rand.Next(0, events.Length);
                var indexAuthor = rand.Next(0, authors.Length);
                var indexCity = rand.Next(0, cities.Length);
                Console.WriteLine($"{phrases[indexPhrase]} {events[indexEvent]} {authors[indexAuthor]} - {cities[indexCity]}");
            }
            
        }
    }
}
