using System;


namespace _07.MultiplyBigNumbers
{
    public class MultiplyBigNumbers
    {
        public static void Main()
        {
            var num1 = Console.ReadLine();
            var num2 = Console.ReadLine();

            var result = Multiply(num1, num2);

            Console.WriteLine(result);
        }

        public static string Multiply(string num1, string num2)
        {
            if (num2 == "0")
            {
                return "0";
            }

            var rem = 0;
            var mult = 0;
            var result = string.Empty;

            while (num1[0] == '0')
            {
                num1 = num1.Remove(0, 1);
            }

            for (int i = 0; i < num1.Length; i++)
            {
                mult = ((num1[num1.Length - 1 - i] - '0') * (num2[0] - '0')) + rem;
                rem = mult / 10;
                mult = mult % 10;
                result = mult + result;
            }

            if (rem > 0)
            {
                result = rem + result;
            }

            return result;
        }
    }
}
