using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace _02.ConvertFromBaseNToDecimal
{
    public class ConvertFromBaseNToDecimal
    {
        public static void Main()
        {
            var input = Console.ReadLine().Split();
            var baseN = int.Parse(input[0]);
            var number = input[1];
            BigInteger result = 0;
            for (int i = 0; i < number.Length; i++)
            {
                result += (number[number.Length - 1 - i] - '0') * BigInteger.Pow(baseN, i);
            }

            Console.WriteLine(result);
        }
    }
}
