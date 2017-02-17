using System;
using System.IO;
using System.Linq;

namespace _01.MostFrequentNumber
{
    public class MostFrequentNumber
    {
        public static void Main(string[] args)
        {
            var file = "Input.txt";
            var input = File.ReadAllLines(file);

            foreach (var line in input)
            {
                var lineArgs = line.Split().Select(int.Parse).ToArray();
                var MFN = 0;
                var maxCount = 0;
                foreach (var num in lineArgs)
                {
                    int count = 0;
                    for (int i = 0; i < lineArgs.Length; i++)
                    {
                        if (num == lineArgs[i])
                        {
                            count++;
                        }
                    }
                    if (count > maxCount)
                    {
                        maxCount = count;
                        MFN = num;
                    }
                }

                File.AppendAllText("Output.txt", $"{MFN}{Environment.NewLine}");
            }
        }
    }
}

