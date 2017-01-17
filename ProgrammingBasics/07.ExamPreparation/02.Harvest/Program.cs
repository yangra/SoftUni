using System;

namespace _02.Harvest
{
    class Program
    {
        static void Main(string[] args)
        {
            int sqM = int.Parse(Console.ReadLine());
            double grapesPerM = double.Parse(Console.ReadLine());
            int litresNeeded = int.Parse(Console.ReadLine());
            int workers = int.Parse(Console.ReadLine());

            double litresProduced = ((sqM * grapesPerM)*0.4)/2.5;
            if (litresNeeded>litresProduced)
            {
                Console.WriteLine("It will be a tough winter! More {0} liters wine needed.", 
                    Math.Floor(litresNeeded-litresProduced));
            }
            else
            {
                Console.WriteLine("Good harvest this year! Total wine: {0} liters.",
                    Math.Floor(litresProduced));
                Console.WriteLine("{0} liters left -> {1} liters per person.",
                    Math.Ceiling(litresProduced-litresNeeded),
                    Math.Ceiling((litresProduced-litresNeeded)/workers));
            }
        }
    }
}
