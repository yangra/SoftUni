using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.CrossingSequences
{
    class Program
    {
        static void Main(string[] args)
        {
            int tri1 = int.Parse(Console.ReadLine());
            int tri2 = int.Parse(Console.ReadLine());
            int tri3 = int.Parse(Console.ReadLine());
            int spiralStart = int.Parse(Console.ReadLine());
            int spiralStep = int.Parse(Console.ReadLine());

            int[] a = new int[1000000];
            a[0] = tri1;
            a[1] = tri2;
            a[2] = tri3;
            int next = 0;
            for (int i = 0, j = 1, k = 2; next <= 1000000; i++, j++, k++)
            {
                next = a[i] + a[j] + a[k];
                a[k + 1] = next;
            }
            int spiralNext = spiralStart;
            int result = 0;
            bool hasValue = false;

            for (int i = 1; spiralNext <= 1000000; i ++)
            {
                if(hasValue)
                {
                    break;
                }
                for (int m = 0; m < 2; m++)
                {
                    if (hasValue)
                    {
                        break;
                    }

                    for (int k = 0; k < a.Length; k++)
                    {
                        if (spiralNext == a[k])
                        {
                            result = spiralNext;
                            hasValue = true;
                            break;
                        }
                    }

                    spiralNext += spiralStep*i;
                }
            }

            if (hasValue)
            {
                Console.WriteLine(result);
            }
            else
            {
                Console.WriteLine("No");
            }

        }
    }
}
