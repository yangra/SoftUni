using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.MaxSequenceOfEqualElements
{
    public class MaxSequenceOfEqualElements
    {
        public static void Main()
        {
            var file = File.ReadAllLines("Input.txt");
            foreach (var line in file)
            {
                var args = line.Split().Select(int.Parse).ToArray();
                var bestIndex = 0;
                var bestLength = 1;
                for (int i = 0; i < args.Length; i++)
                {
                    int index = i+1;
                    var length = 1;
                    while (index<args.Length&&args[i] == args[index])
                    {
                        length++;
                        index++;
                    }
                    if (length>bestLength)
                    {
                        bestLength = length;
                        bestIndex = i;
                    }
                }

                for (int i = bestIndex; i < bestLength+bestIndex; i++)
                {
                    File.AppendAllText("Output.txt", $"{args[i]} ");
                }
                File.AppendAllText("Output.txt", $"{Environment.NewLine}");
            }
        }
    }
}
