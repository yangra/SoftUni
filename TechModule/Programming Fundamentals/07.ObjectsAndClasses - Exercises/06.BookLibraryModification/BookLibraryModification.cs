using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.BookLibraryModification
{
    class BookLibraryModification
    {
        static void Main()
        {
            Library library = new Library()
            {
                Books = new List<Book>(),
                Name = "Library"
            };

            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine().Split();
                Book book = new Book
                {
                    Title = input[0],
                    Author = input[1],
                    Publisher = input[2],
                    ReleaseDate = DateTime.ParseExact(input[3], "dd.MM.yyyy", CultureInfo.InvariantCulture),
                    ISBN = input[4],
                    Price = double.Parse(input[5])
                };

                library.Books.Add(book);
            }

            DateTime startDate = DateTime.ParseExact(Console.ReadLine(), "dd.MM.yyyy", CultureInfo.InvariantCulture);

            var allTitlesAfterGivenDate = library.Books.Where(b => b.ReleaseDate > startDate).OrderBy(b => b.ReleaseDate).ThenBy(b => b.Title);

            foreach (var book in allTitlesAfterGivenDate)
            {
                Console.WriteLine($"{book.Title} -> {book.ReleaseDate:dd.MM.yyyy}");
            }
        }
    }
}
