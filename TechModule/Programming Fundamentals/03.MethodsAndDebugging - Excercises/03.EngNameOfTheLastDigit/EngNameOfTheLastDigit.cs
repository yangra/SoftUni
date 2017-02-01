using System;

namespace MethodsAndDebugging
{
    public class EngNameOfTheLastDigit
    {
        public static void Main()
        {
            long num = long.Parse(Console.ReadLine());

            int lastDigit = (int)(Math.Abs(num) % 10);
            string digit = ConvertNumToWord(lastDigit);
            Console.WriteLine(digit);
        }

        public static string ConvertNumToWord(int digit)
        {
            string stringDigit = string.Empty;
            switch (digit)
            {

                case 1: stringDigit = "one"; break;
                case 2: stringDigit = "two"; break;
                case 3: stringDigit = "three"; break;
                case 4: stringDigit = "four"; break;
                case 5: stringDigit = "five"; break;
                case 6: stringDigit = "six"; break;
                case 7: stringDigit = "seven"; break;
                case 8: stringDigit = "eight"; break;
                case 9: stringDigit = "nine"; break;
                case 0: stringDigit = "zero"; break;
            }
            return stringDigit;
        }
    }
}
