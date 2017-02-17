using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.CharacterMultiplier
{
    public class CharacterMultiplier
    {
        public static void Main(string[] args)
        {
            var input = Console.ReadLine().Split();
            var result = 0L;
            if (input[0].Length >= input[1].Length)
            {
                result = Multiply(input[0], input[1], result);
            }
            else
            {
                result = Multiply(input[1], input[0], result);
            }

            Console.WriteLine(result);
        }

        private static long Multiply(string inputLong, string inputShort, long result)
        {
            for (int i = 0; i < inputShort.Length; i++)
            {
                var codeOne = (int)inputLong[i];
                var codeTwo = (int)inputShort[i];
                result += (codeOne * codeTwo);
            }
            for (int i = inputShort.Length; i < inputLong.Length; i++)
            {
                var code = inputLong[i] - 0;
                result += code;
            }

            return result;
        }
    }
}
