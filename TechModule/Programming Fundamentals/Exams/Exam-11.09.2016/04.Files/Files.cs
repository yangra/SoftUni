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
            var N = int.Parse(Console.ReadLine());
            var files = new Dictionary<string, Dictionary<string, File>>();
            for (int i = 0; i < N; i++)
            {
                var line = Console.ReadLine();

                var size = line.Split(';').Skip(1).Select(long.Parse).ToArray();
                var splitted = line.Split(';').First();
                var extension = splitted.Split('.').Last();
                var name = splitted.Split('\\').Last();
                var root = line.Split('\\').First();

                if (!files.ContainsKey(root))
                {
                    var file = new File
                    {
                        Name = name,
                        Extension = extension,
                        Size = size[0],
                        Root = root
                    };

                    files[root] = new Dictionary<string, File>();
                    files[root][name] = file;
                }
                else
                {
                    var file = new File
                    {
                        Name = name,
                        Extension = extension,
                        Size = size[0],
                        Root = root
                    };

                    files[root][name] = file;
                }
            }
            var search = Console.ReadLine();
            var ext = search.Split().First();
            var dir = search.Split().Last();
            var result = new List<File>();

            if (files.ContainsKey(dir))
            {
                foreach (var file in files[dir])
                {
                    if (file.Value.Extension.Equals(ext))
                    {
                        result.Add(file.Value);
                    }
                }

                if (result.Count > 0)
                {
                    result = result.OrderByDescending(f => f.Size).ThenBy(f => f.Name).ToList();
                    foreach (var file in result)
                    {
                        Console.WriteLine($"{file.Name} - {file.Size} KB");
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
            }
        }
    }
}
