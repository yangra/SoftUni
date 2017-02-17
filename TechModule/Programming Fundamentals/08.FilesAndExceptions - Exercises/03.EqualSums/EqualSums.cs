using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.EqualSums
{
    public class EqualSums
    {
        public static void Main()
        {
            var file = File.ReadAllLines("Input.txt");
            foreach (var line in file)
            {
                var lineArgs = line.Split().Select(int.Parse).ToArray();
                bool exists = false;
                for (int i = 0; i < lineArgs.Length; i++)
                {
                    var sumLeft = 0;
                    var sumRight = 0;
                    for (int j = 0; j < i; j++)
                    {
                        sumLeft += lineArgs[j];
                    }
                    for (int j = i+1; j < lineArgs.Length; j++)
                    {
                        sumRight += lineArgs[j];
                    }

                    if (sumLeft == sumRight)
                    {
                        exists = true;
                        File.AppendAllText("Output.txt", $"{i}{Environment.NewLine}");
                        break;
                    }
                }
                if (!exists)
                {
                    File.AppendAllText("Output.txt", $"no{Environment.NewLine}");
                }
            }
        }
    }
}
