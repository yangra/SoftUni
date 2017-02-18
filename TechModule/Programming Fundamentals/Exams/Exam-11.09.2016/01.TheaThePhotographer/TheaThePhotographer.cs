using System;

namespace _01.TheaThePhotographer
{
    public class TheaThePhotographer
    {
        public static void Main()
        {
            int picturesTaken = int.Parse(Console.ReadLine());
            int filteringTime = int.Parse(Console.ReadLine());
            int filterFactor = int.Parse(Console.ReadLine());
            int uploadTime = int.Parse(Console.ReadLine());

            long filteringTimeTotal = (long)picturesTaken * filteringTime;
            int usefulPictures = (int)Math.Ceiling(picturesTaken * (filterFactor / 100.0));
            long uploadTimeTotal = (long)usefulPictures * uploadTime;
            long timeTotal = filteringTimeTotal + uploadTimeTotal;
            
            TimeSpan result = TimeSpan.FromSeconds(timeTotal);
            Console.WriteLine($"{result.Days:0}:{result.Hours:00}:{result.Minutes:00}:{result.Seconds:00}");
           
            
        }
    }
}
