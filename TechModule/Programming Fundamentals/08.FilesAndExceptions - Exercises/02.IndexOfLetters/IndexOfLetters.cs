using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.IndexOfLetters
{
    public class IndexOfLetters
    {
        public static void Main()
        {
            var file = File.ReadAllLines("Input.txt");
            var alphabet = new char[26];
            for (int i = 0; i < alphabet.Length; i++)
            {
                alphabet[i] = (char)('a' + i);
            }
            foreach (var line in file)
            {
                foreach (var item in line)
                {
                    for(int i = 0;i< alphabet.Length;i++)
                    {
                        if (item == alphabet[i])
                        {
                            File.AppendAllText("Output.txt", $"{item} -> {i}{Environment.NewLine}");
                        }
                    }
                }
            }
        }
    }
}
