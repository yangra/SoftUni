using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Files
{
    class Program
    {
        static void Main(string[] args)
        {
            var filesByRoot = new Dictionary<string, Dictionary<string, long>>();
            var n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine().Split('\\');
                var root = input.First();
                var fileDetails = input.Last().Split(';');
                var fileName = fileDetails.First();
                var fileSize = long.Parse(fileDetails.Last());

                if (!filesByRoot.ContainsKey(root))
                {
                    filesByRoot[root] = new Dictionary<string, long>();
                }

                filesByRoot[root][fileName] = fileSize;
            }

            var query = Console.ReadLine().Split();
            var queryExt = query.First();
            var queryRoot = query.Last();
            if (filesByRoot.ContainsKey(queryRoot))
            {
                var found = false;
                foreach (var file in filesByRoot[queryRoot].OrderByDescending(f=>f.Value).ThenBy(f=>f.Key))
                {
                    if (file.Key.EndsWith(queryExt))
                    {
                        found = true;
                        Console.WriteLine("{0} - {1} KB", file.Key, file.Value);
                    }
                    
                }
                if (!found)
                {
                    Console.WriteLine("No");
                }
            }
            else
            {
                Console.WriteLine("No");
            }
            
        }
    }
}
