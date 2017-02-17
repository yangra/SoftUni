using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace _04.QueryMess
{
    public class QueryMess
    {
        public static void Main()
        {
            var result = new Dictionary<string, List<string>>();
            var input = Console.ReadLine();
            while (input != "END")
            {
                if (input.Contains("?"))
                {
                    var splitted = input.Split('?');
                    input = splitted[1];
                }
                input = input.Replace("%20", " ");
                input = input.Replace("+", " ");
                var regex = new Regex(@"\s+");
                input = regex.Replace(input, " ");

                var values = input.Split('&');
                foreach (var value in values)
                {
                    var args = value.Split('=');
                    var key = args[0].Trim();
                    var val = args[1].Trim();
                    if (!result.ContainsKey(key))
                    {
                        result[key] = new List<string>();
                    }

                    result[key].Add(val);

                }

                PrintResult(result);

                result = new Dictionary<string, List<string>>();
                input = Console.ReadLine();
            }
        }

        public static void PrintResult(Dictionary<string, List<string>> result)
        {
            foreach (var value in result)
            {
                Console.Write("{0}=", value.Key);
                Console.Write("[{0}]", string.Join(", ", value.Value));
            }
            Console.WriteLine();
        }
    }
}
