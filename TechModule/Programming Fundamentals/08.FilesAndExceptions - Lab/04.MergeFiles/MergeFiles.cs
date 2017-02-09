using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.MergeFiles
{
    public class MergeFiles
    {
        public static void Main()
        {
            var textOne = File.ReadAllLines("FileOne.txt");
            var textTwo = File.ReadAllLines("FileTwo.txt");

            if (!File.Exists("result.txt"))
            {
                File.Create("result.txt");
            }

            for (int i = 0; i < textOne.Length; i++)
            {
                File.AppendAllText("result.txt", $"{textOne[i]}{Environment.NewLine}");
                File.AppendAllText("result.txt", $"{textTwo[i]}{Environment.NewLine}");
            }
        }
    }
}
