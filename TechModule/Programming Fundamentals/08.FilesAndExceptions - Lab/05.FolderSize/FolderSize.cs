using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.FolderSize
{
    public class FolderSize
    {
        public static void Main()
        {
            var directories = Directory.GetDirectories("TestFolder");
            var files = Directory.GetFiles("TestFolder");
            var sum = 0L;
            
            foreach (var file in files)
            {
                FileInfo info = new FileInfo(file);
                sum += info.Length;
            }

            var result = sum / 1024.0 / 1024;
            Console.WriteLine(result);
        }
    }
}
