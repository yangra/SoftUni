using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _03.ValidUsernames
{
    public class ValidUsernames
    {
        public static void Main()
        {
            var data = Console.ReadLine().Split(new char[] { ' ', '\\', '/', '(', ')' }, StringSplitOptions.RemoveEmptyEntries);

            var regex = new Regex(@"\b[a-zA-Z](\w){2,24}\b");
            var valid = new List<string>();
            foreach (var item in data)
            {
                if (regex.IsMatch(item))
                {
                    valid.Add(item.ToString());
                }
            }
            var maxSum = 0;
            string first = "";
            string second = "";

            for (int i = 0; i < valid.Count - 1; i++)
            {
                var sum = 0;
                sum = valid[i].Length + valid[i + 1].Length;

                if (maxSum < sum)
                {
                    maxSum = sum;
                    first = valid[i];
                    second = valid[i + 1];
                }

            }

            Console.WriteLine(first);
            Console.WriteLine(second);
        }
    }
}
