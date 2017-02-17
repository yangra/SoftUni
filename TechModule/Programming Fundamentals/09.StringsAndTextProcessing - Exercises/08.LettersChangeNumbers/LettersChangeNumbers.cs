using System;

namespace _08.LettersChangeNumbers
{
    public class LettersChangeNumbers
    {
        public static void Main(string[] args)
        {
            var input = Console.ReadLine().Split(new char[] { ' ', '\t' }, StringSplitOptions.RemoveEmptyEntries);
            var result = 0m;
            for (int i = 0; i < input.Length; i++)
            {
                var front = input[i][0];
                var back = input[i][input[i].Length - 1];
                var number = long.Parse(input[i].Remove(input[i].Length - 1, 1).Remove(0, 1));
                var buffer = 0m;
                if (front - 'a' >= 0)
                {
                    buffer += number * ((front - 'a') + 1);
                }
                else
                {
                    buffer += number / (decimal)((front - 'A') + 1);
                }

                if (back - 'a' >= 0)
                {
                    buffer += ((back - 'a') + 1);
                }
                else
                {
                    buffer -= ((back - 'A') + 1);
                }

                result += buffer;
            }

            Console.WriteLine("{0:F2}", result);
        }
    }
}
