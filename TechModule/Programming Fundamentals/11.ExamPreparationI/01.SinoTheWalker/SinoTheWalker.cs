using System;
using System.Globalization;

namespace _01.SinoTheWalker
{
    public class SinoTheWalker
    {
        public static void Main()
        {
            var startingTime = DateTime.ParseExact(Console.ReadLine(), "HH:mm:ss", CultureInfo.InvariantCulture);
            var numberOfSteps = int.Parse(Console.ReadLine());
            var secondsPerEachStep = int.Parse(Console.ReadLine());
            long secondsToAdd = (long)numberOfSteps * secondsPerEachStep;
            var totalSeconds = secondsToAdd + startingTime.Hour * 60 * 60 + startingTime.Minute * 60 + startingTime.Second;
            var seconds = totalSeconds % 60;
            var totalMinutes = totalSeconds / 60;
            var minutes = totalMinutes % 60;
            var totalHours = totalMinutes / 60;
            var hours = totalHours % 24;

            Console.WriteLine($"Time Arrival: {hours:00}:{minutes:00}:{seconds:00}");
        }
    }
}
