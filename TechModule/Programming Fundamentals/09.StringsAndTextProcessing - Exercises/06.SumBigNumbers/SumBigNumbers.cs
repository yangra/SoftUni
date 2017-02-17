using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.SumBigNumbers
{
    public class SumBigNumbers
    {
        public static void Main()
        {
            var num1 = Console.ReadLine();
            var num2 = Console.ReadLine();
            string result = SumNumbers(num1, num2);
            Console.WriteLine(result);

        }

        public static string SumNumbers(string num1, string num2)
        {
            var rem = 0;
            var result = new StringBuilder();

            while (num1[0] == '0')
            {
                num1 = num1.Remove(0, 1);
            }

            while (num2[0] == '0')
            {
                num2 = num2.Remove(0, 1);
            }

            if (num1.Length >= num2.Length)
            {
                for (int i = 0; i < num2.Length; i++)
                {
                    var sum = (num1[num1.Length - 1 - i] - '0') + (num2[num2.Length - 1 - i] - '0') + rem;
                    rem = 0;
                    rem = sum / 10;
                    sum = sum % 10;
                    result.Append(sum);
                }

                for (int i = num2.Length; i < num1.Length; i++)
                {
                    var sum = (num1[num1.Length - 1 - i] - '0') + rem;
                    rem = 0;
                    rem = sum / 10;
                    sum = sum % 10;
                    result.Append(sum);
                }

                if (rem > 0)
                {
                    result.Append(rem);
                }
            }
            else
            {
                return SumNumbers(num2, num1);
            }

            var reversed = result.ToString();
            result = new StringBuilder();
            for (int i = 0; i < reversed.Length; i++)
            {
                result.Append(reversed[reversed.Length - 1 - i]);
            }
            return result.ToString();
        }
    }
}
