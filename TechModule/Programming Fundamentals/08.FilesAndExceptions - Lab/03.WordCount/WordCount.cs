using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.WordCount
{
    public class WordCount
    {
        public static void Main()
        {
            var needle = File.ReadAllText("words.txt").ToLower();
            var words = needle.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Distinct();
            var hay = File.ReadAllText("text.txt").ToLower();
            var text = hay.Split(new char[] { '\n', '\r', ' ', '.', ',', '!', '?', '-' }, StringSplitOptions.RemoveEmptyEntries);
            var result = new Dictionary<string, int>();
            foreach (var word in words)
            {
                result[word] = 0;
            }

            foreach (var word in text)
            {
                if (result.ContainsKey(word))
                {
                    result[word]++;
                }
            }
            result = result.OrderByDescending(w => w.Value).ToDictionary(w => w.Key, w => w.Value);
            foreach (var word in result)
            {
                File.AppendAllText("result.txt", $"{word.Key} - {word.Value}{Environment.NewLine}");
            }
        }
    }
}
