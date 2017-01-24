using System;

namespace _19.TheaThePhotographer
{
    class Program
    {
        static void Main(string[] args)
        {
            int numberOfPictures = int.Parse(Console.ReadLine());
            int filterEachTime = int.Parse(Console.ReadLine());
            int filterFactor = int.Parse(Console.ReadLine());
            int uploadTime = int.Parse(Console.ReadLine());

            long filteringTime = (long)numberOfPictures * filterEachTime;
            long filteredPictures = (long)Math.Ceiling((filterFactor / 100.0) * numberOfPictures);
            long totalTimeInSec =  filteringTime + (filteredPictures * uploadTime);

            TimeSpan time = TimeSpan.FromSeconds(totalTimeInSec);
            Console.WriteLine("{0:D1}:{1:D2}:{2:D2}:{3:D2}", time.Days, time.Hours, time.Minutes, time.Seconds);
        }
    }
}
