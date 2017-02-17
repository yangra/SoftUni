using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.UnicodeCharcters
{
    public class UnicodeCharcters
    {
        public static void Main()
        {
            var input = Console.ReadLine();
            for (int i = 0; i < input.Length; i++)
            {
                var sign = input[i];
                var code = sign - 0;
                var result = new StringBuilder();
                while (code>0)
                {
                    var rem = code % 16;
                    if (rem>9)
                    {
                        if (rem==10)
                        {
                            result.Append('a');
                        }
                        else if (rem==11)
                        {
                            result.Append('b');
                        }
                        else if (rem==12)
                        {
                            result.Append('c');
                        }
                        else if (rem==13)
                        {
                            result.Append('d');
                        }
                        else if (rem == 14)
                        {
                            result.Append('e');
                        }
                        else if (rem==15)
                        {
                            result.Append('f');
                        }
                    }
                    else
                    {
                        result.Append(rem);
                    }
                    code /= 16;
                }
                var unicode = string.Join("",result.ToString().Reverse().ToArray());
                Console.Write("\\u{0}",unicode.PadLeft(4,'0'));
            }
        }
    }
}
