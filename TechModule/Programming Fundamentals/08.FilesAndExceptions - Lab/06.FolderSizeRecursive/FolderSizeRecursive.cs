using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.FolderSizeRecursive
{
    public class FolderSizeRecursive
    {
        public static void Main(string[] args)
        {
            var currentDir = Directory.GetCurrentDirectory();
            var dirInfo = new DirectoryInfo(currentDir);
            var rootDirectory = dirInfo.Parent.Parent;

            TraverseDirectory(rootDirectory);
        }

        public static void TraverseDirectory(DirectoryInfo currentDir, string prefix = "")
        {
            foreach (var dir in currentDir.GetDirectories())
            {
                Console.WriteLine(prefix + dir.Name);
                TraverseDirectory(dir, prefix + "--");
            }

            foreach (var file in currentDir.GetFiles())
            {
                Console.WriteLine(prefix + "--" + file.Name);
            }
        }
    }
}
