using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Files
{
    public class Files
    {

        public static void Main()
        {

            var files = new Dictionary<string, Dictionary<string, long>>();
            
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine();
                var size = long.Parse(input.Split(';').Last());
                var root = input.Split('\\').First();
                var path = input.Split(';').First();
                var extension = path.Split('.').Last();
                var fileName = path.Split('\\').Last();
                if (!files.ContainsKey(root))
                {
                    files[root] = new Dictionary<string, long>();
                    files[root][fileName] = size;
                }
                else
                {
                    files[root][fileName] = size;
                }
            }
            var search = Console.ReadLine();
            var ext = search.Split().First();
            var dir = search.Split().Last();
            if (files.ContainsKey(dir))
            {
                var result = files[dir].Where(f => f.Key.EndsWith(ext)).OrderByDescending(f => f.Value).ThenBy(f => f.Key);

                if (result.Count()>0)
                {
                    foreach (var item in result)
                    {
                        Console.WriteLine($"{item.Key} - {item.Value} KB");
                    }
                }
                else
                {
                    Console.WriteLine("No");
                }  
            }
            else
            {
                Console.WriteLine("No");
                return;
            }
        }
    }
}
