using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.CharityMarathon
{
    public class CharityMarathon
    {
        public static void Main(string[] args)
        {
            var daysLength = int.Parse(Console.ReadLine());
            var numberOfRunners = int.Parse(Console.ReadLine());
            var avgLaps = int.Parse(Console.ReadLine());
            var trackLength = int.Parse(Console.ReadLine());
            var trackCapacity = int.Parse(Console.ReadLine());
            var moneyDonatedPerKM = decimal.Parse(Console.ReadLine());
            var actualRunners = 0; ;
            var maxRunners = daysLength * trackCapacity;
            if (maxRunners >= numberOfRunners)
            {
                actualRunners = numberOfRunners;
            }
            else
            {
                actualRunners = maxRunners;
            }

            long totalMeters = (long)actualRunners * avgLaps * trackLength;
            decimal totalKM = totalMeters / (decimal)1000;
            var totalDonatedMoney = totalKM * moneyDonatedPerKM;

            Console.WriteLine("Money raised: {0:F2}",totalDonatedMoney);
        }
    }
}
