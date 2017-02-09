using System;
using System.Collections.Generic;
using System.IO;

namespace _01.OddLines
{
    public class OddLines
    {
        public static void Main()
        {
            var file = "input.txt";
            var lines = File.ReadAllLines(file);
            if (!File.Exists("result.txt"))
            {
                File.Create("result.txt");
            }

            var oddLines = new List<string>();
            for (int i = 0; i < lines.Length; i++)
            {
                if (i % 2 != 0)
                {
                    oddLines.Add(lines[i]);
                }
            }

            File.WriteAllLines("result.txt", oddLines);
        }
    }
}
