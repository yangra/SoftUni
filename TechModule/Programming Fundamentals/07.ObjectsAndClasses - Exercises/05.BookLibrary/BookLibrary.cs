using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;

namespace _05.BookLibrary
{
    class BookLibrary
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            Library library = new Library()
            {
                Books = new List<Book>(),
                Name = "Biblioteka"

            };

            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine().Split(' ');
                Book book = new Book()
                {
                    Title = input[0],
                    Author = input[1],
                    Publisher = input[2],
                    ReleaseDate = DateTime.ParseExact(input[3],"dd.MM.yyyy", CultureInfo.InvariantCulture),
                    ISBN = input[4],
                    Price = double.Parse(input[5])
                };

                library.Books.Add(book);
            }

            var sumOfPricesByAuthor = library.Books.GroupBy(b => b.Author)
                                             .Select(g => new
                                            {
                                                Author = g.Key,
                                                Price = g.Sum(m => m.Price)
                                            }).OrderByDescending(a=>a.Price).ThenBy(c=>c.Author);

            foreach (var item in sumOfPricesByAuthor)
            {
                Console.WriteLine($"{item.Author} -> {item.Price:F2}");
            }
            
        }
    }
}
