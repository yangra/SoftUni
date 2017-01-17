using System;

namespace _13.NumPyr
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int num = 1;
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j <= i; j++,num++)
                {
                    Console.Write("{0} ",num);
                    if (num == n)
                    {
                        return;
                    }
                }
                Console.WriteLine();
            }
        }
    }
}
