using System;
using System.Text;


namespace _01.ReaverseString
{
    public class ReverseString
    {
        public static void Main()
        {
            var input = Console.ReadLine();
            var result = new StringBuilder();
            for (int i = input.Length-1; i >=0 ; i--)
            {
                result.Append(input[i]);
            }
            Console.WriteLine(result.ToString());
        }
    }
}
