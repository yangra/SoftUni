using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Illuminati
{
    class Program
    {
        static void Main(string[] args)
        {
            string message = Console.ReadLine();

            string lower = message.ToLower();
            int count = 0;
            int sum = 0;

            for (int i = 0; i < lower.Length; i++)
            {
                switch (lower[i])
                {
                    case 'a':
                        count++;
                        sum += 65; 
                        break;
                    case 'e':
                        count++;
                        sum += 69;
                        break;
                    case 'i':
                        count++;
                        sum += 73;
                        break;
                    case 'o':
                        count++;
                        sum += 79;
                        break;
                    case 'u':
                        count++;
                        sum += 85;
                        break;
                }
            }

            Console.WriteLine(count);
            Console.WriteLine(sum);
        }
    }
}
