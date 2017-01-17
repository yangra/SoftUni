using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentCables
{
    class Program
    {
        static int wholeLength = 0;
        static int joinsCount = 0;

        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for(int i = 0; i<n;i++)
            {
                int length = int.Parse(Console.ReadLine());
                string measure = Console.ReadLine();

                if(measure == "meters")
                    length *= 100;

                if (length < 20)
                    continue;

                if (i > 0)
                {
                    wholeLength += length;
                    joinsCount++;
                }
                else
                    wholeLength += length;
            }

            wholeLength -= joinsCount * 3;

            int cables = wholeLength / 504;
            int rest = wholeLength % 504;

            Console.WriteLine(cables);
            Console.WriteLine(rest);
        }
    }
}
