using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.MagicExchangeableWords
{
    public class MagicExchangeableWords
    {
        public static void Main()
        {
            var input = Console.ReadLine().Split();
            if (IsEchangeable(input[0],input[1]))
            {
                Console.WriteLine("true");
            }
            else
            {
                Console.WriteLine("false");
            }
        }

        private static bool IsEchangeable(string first, string second)
        {
            var map = new Dictionary<char, char>();
            if (first.Length>=second.Length)
            {
                for (int i = 0; i < second.Length; i++)
                {
                    if (!map.ContainsKey(first[i])&&!map.ContainsValue(second[i]))
                    {
                        map[first[i]] = second[i];
                    }
                    else if (map.ContainsKey(first[i])&&map[first[i]]==second[i])
                    {
                        continue;
                    }
                    else
                    {
                        return false;
                    }
                }

                for (int i = second.Length; i < first.Length; i++)
                {
                    if (map.ContainsKey(first[i]))
                    {
                        continue;
                    }
                    else
                    {
                        return false;
                    }      
                }

            }
            else
            {
                return IsEchangeable(second, first);
            }

            return true;
        }
    }
}
