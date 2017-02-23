using System;
using System.Linq;

namespace _03.EnduranceRally
{
    public class EnduranceRally
    {
        public static void Main()
        {
            var drivers = Console.ReadLine().Split().ToArray();
            var track = Console.ReadLine().Split().Select(double.Parse).ToArray();
            var checkpoints = Console.ReadLine().Split().Select(int.Parse).ToArray();
            foreach (var driver in drivers)
            {
                bool noFuel = false;
                double fuel = driver.First();
                for (int i = 0; i < track.Length; i++)
                {
                    if (checkpoints.Contains(i))
                    {
                        fuel += track[i];
                    }
                    else
                    {
                        fuel -= track[i];
                    }

                    if (fuel<=0)
                    {
                        Console.WriteLine($"{driver} - reached {i}");
                        noFuel = true;
                        break;
                    }
                }

                if (!noFuel)
                {
                    Console.WriteLine($"{driver} - fuel left {fuel:F2}");
                }
            }
                
            
        }
    }
}
