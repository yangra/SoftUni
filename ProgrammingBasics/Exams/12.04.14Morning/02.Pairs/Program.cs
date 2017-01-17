using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Pairs
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string[] seq = input.Split(' ');

            bool equal = true;
            int[] sums = new int [seq.Length/2];
            int maxdiff = 0;
            for (int i = 0, j=0; i < seq.Length; i+=2,j++)
            {
                int val1 = int.Parse(seq[i]);
                int val2 = int.Parse(seq[i+1]);

                sums[j] = val1 + val2;
            }
            for (int i = 0; i < sums.Length-1; i++)
            {
                if (sums[i] == sums[i+1]&&equal)
                {
                    continue;
                }
                equal = false;
                int diff = sums[i] - sums[i + 1];
                if (diff<0)
                {
                    diff *= -1;
                }
                if (diff>maxdiff)
                {
                    maxdiff = diff;
                }
            }
            if (equal)
            {
                Console.WriteLine("Yes, value={0}", sums[0]);
            }
            else
            {
                Console.WriteLine("No, maxdiff={0}",maxdiff);
            }
        }
    }
}
