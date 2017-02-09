using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.LineNumbers
{
    public class LineNumbers
    {
        public static void Main(string[] args)
        {
            var file = "Input.txt";

            var lines = File.ReadAllLines(file);

            if (!File.Exists("result.txt"))
            {
                File.Create("result.txt");
            }

            for (int i = 0; i < lines.Length; i++)
            {
                File.AppendAllText("result.txt", $"{i+1}. {lines[i]}{Environment.NewLine}");
            }

            

        }
    }
}
