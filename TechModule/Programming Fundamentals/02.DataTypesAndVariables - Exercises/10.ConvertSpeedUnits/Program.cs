using System;

namespace _10.ConvertSpeedUnits
{
    class Program
    {
        static void Main(string[] args)
        {
            int distanceInMeters = int.Parse(Console.ReadLine());
            int hours = int.Parse(Console.ReadLine());
            int minutes = int.Parse(Console.ReadLine());
            int seconds = int.Parse(Console.ReadLine());

            int timeInSec = hours * 60 * 60 + minutes * 60 + seconds;
            float metersPerSecond = (float)distanceInMeters / timeInSec;
            float kmPerHour = ((float)distanceInMeters / 1000) / ((float)timeInSec / 3600);
            float milesPerHour = ((float)distanceInMeters / 1609) / ((float)timeInSec / 3600);

            Console.WriteLine("{0}", metersPerSecond);
            Console.WriteLine("{0}", kmPerHour);
            Console.WriteLine("{0}", milesPerHour);
        }
    }
}
