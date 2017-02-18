using System;
using System.Globalization;

namespace _01.SinoTheWalker
{
    public class SinoTheWalker
    {
        public static void Main()
        {
            var leaveTime = DateTime.ParseExact(Console.ReadLine(), "HH:mm:ss", CultureInfo.InvariantCulture);
            var steps = int.Parse(Console.ReadLine());
            int timeForEachStep = int.Parse(Console.ReadLine());
            var elapsedTime = ((long)steps * timeForEachStep)%86400.0;

            TimeSpan elapsed = TimeSpan.FromSeconds(elapsedTime);
            var arriveTime = leaveTime + elapsed;

            Console.WriteLine("Time Arrival: {0:00}:{1:00}:{2:00}", arriveTime.Hour,arriveTime.Minute,arriveTime.Second);
        }
    }
}
