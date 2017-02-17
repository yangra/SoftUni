using System;
using System.Linq;
using System.Numerics;
using System.Text;

namespace _01.ConvertFromBase10ToBaseN
{
    public class ConvertFromBase10ToBaseN
    {
        public static void Main()
        {
            var input = Console.ReadLine().Split();
            var N = int.Parse(input[0]);
            var numBase10 = BigInteger.Parse(input[1]);
            
            var result = new StringBuilder();
            while (numBase10 > 0)
            {
                result.Append(numBase10 % N);
                numBase10 /= N;
            }

            Console.WriteLine(result.ToString().Reverse().ToArray());
        }
    }
}
