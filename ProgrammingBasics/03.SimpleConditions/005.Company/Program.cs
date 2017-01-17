using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _005.Company
{
    class Program
    {
        static void Main(string[] args)
        {
            int neededHours = int.Parse(Console.ReadLine());
            int days = int.Parse(Console.ReadLine());
            int employees = int.Parse(Console.ReadLine());

            double totalHours = Math.Floor(days * 0.9 * 8 + (employees * 2 * days));
            if (totalHours>=neededHours)
            {
                Console.WriteLine("Yes!{0} hours left.",totalHours-neededHours);
            }else
            {
                Console.WriteLine("Not enough time!{0} hours needed.",neededHours-totalHours);
            }
        }
    }
}
