using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.HogwartsSorting
{

    public class HogwartsSorting
    {
        public static void Main()
        {
            int count = int.Parse(Console.ReadLine());
            var houses = new int[4];
            for (int i = 0; i < count; i++)
            {
                var name = Console.ReadLine().Split();
                var asciiSum = 0;
                for (int j = 0; j < name[0].Length; j++)
                {
                    asciiSum += name[0][j];
                }
                for (int k = 0; k < name[1].Length; k++)
                {
                    asciiSum += name[1][k];
                }

                if (asciiSum%4==0)
                {
                    Console.Write("Gryffindor ");
                    houses[0]++;
                }
                else if (asciiSum%4 == 1)
                {
                    Console.Write("Slytherin ");
                    houses[1]++;
                }
                else if (asciiSum % 4 == 2)
                {
                    Console.Write("Ravenclaw ");
                    houses[2]++;
                }
                else if (asciiSum % 4 == 3)
                {
                    Console.Write("Hufflepuff ");
                    houses[3]++;
                }
                Console.WriteLine("{0}{1}{2}", asciiSum,name[0][0],name[1][0]);
            }
            Console.WriteLine();
            Console.WriteLine("Gryffindor: {0}", houses[0]);
            Console.WriteLine("Slytherin: {0}", houses[1]);
            Console.WriteLine("Ravenclaw: {0}", houses[2]);
            Console.WriteLine("Hufflepuff: {0}", houses[3]);
        }
    }
}

