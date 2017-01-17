using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _18.DailyGain
{
    class Program
    {
        static void Main(string[] args)
        {
            int workDays = int.Parse(Console.ReadLine());
            double payPerDay = double.Parse(Console.ReadLine());
            double USDBGN = double.Parse(Console.ReadLine());

            double monthlyPay = workDays * payPerDay;
            double dailyGain = ((((monthlyPay * 12) + (2.5 * monthlyPay)) * 0.75) * USDBGN) / 365;
            Console.WriteLine("{0:F2}",dailyGain);
        }
    }
}
