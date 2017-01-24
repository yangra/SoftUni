using System;

namespace _04.StringToBoolean
{
    class Program
    {
        static void Main(string[] args)
        {
            string read = Console.ReadLine();
            bool converted = Convert.ToBoolean(read);
            if (converted)
                Console.WriteLine("Yes");
            else
                Console.WriteLine("No");
        }
    }
}
