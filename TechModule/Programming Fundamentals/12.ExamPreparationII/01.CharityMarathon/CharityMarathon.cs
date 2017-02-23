using System;

namespace _01.CharityMarathon
{
    class CharityMarathon
    {
        static void Main(string[] args)
        {
            var daysCount = int.Parse(Console.ReadLine());
            var runnerCount = int.Parse(Console.ReadLine());
            var AvgNumberOfLaps = int.Parse(Console.ReadLine());
            var lapLength = int.Parse(Console.ReadLine());
            var trackCapacity = int.Parse(Console.ReadLine());
            var moneyPerKm = decimal.Parse(Console.ReadLine());
            var totalDistance = 0L;
            if (daysCount*trackCapacity>=runnerCount)
            {
                totalDistance = (long)runnerCount * AvgNumberOfLaps * lapLength;
            }
            else
            {
                totalDistance = (long)daysCount * trackCapacity * AvgNumberOfLaps * lapLength;
            }
            var totalKM = totalDistance / 1000m;
            var moneyRaised = totalKM * moneyPerKm;

            Console.WriteLine("Money raised: {0:F2}", moneyRaised);
        }
    }
}
