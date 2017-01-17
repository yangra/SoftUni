using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _003.ClaverLily
{
    class Program
    {
        static void Main(string[] args)
        {
            int age = int.Parse(Console.ReadLine());
            double cost = double.Parse(Console.ReadLine());
            int singleValue = int.Parse(Console.ReadLine());

            double sum = 0;


            for (int i = 1; i <= age; i++)
            {
                if (i % 2 == 0)
                {
                    sum += ((i / 2) * 10) - 1;
                }
                else
                {
                    sum += singleValue;
                }
            }
            if (sum >= cost)
            {
                Console.WriteLine("Yes! {0:f2}", sum - cost);
            }
            else
            {
                Console.WriteLine("No! {0:f2}", cost - sum);
            }

        }
    }
}
