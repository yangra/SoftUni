using System;
using System.Collections.Generic;
using System.Linq;

namespace _04.VehiclePark
{
    public class VehiclePark
    {
        public static void Main()
        {
            var vehicles = Console.ReadLine().Split().ToList();
            var request = Console.ReadLine();
            var vehiclesSold = new List<string>();
            while (!request.Equals("End of customers!"))
            {
                var args = request.Split();
                var type = args[0];
                var numOfSeats = args[2];
                var lookFor = type.ToLower()[0] + numOfSeats;
                bool sold = false;
                for (int i = 0; i < vehicles.Count; i++)
                {
                    if (vehicles[i].Equals(lookFor))
                    {
                        var price = type.ToLower()[0] * int.Parse(numOfSeats);
                        Console.WriteLine("Yes, sold for {0}$",price );
                        vehiclesSold.Add(vehicles[i]);
                        vehicles.RemoveAt(i);
                        sold = true;
                        break;
                    }
                }
                if (!sold)
                {
                    Console.WriteLine("No");
                }

                request = Console.ReadLine();
            }

            Console.WriteLine("Vehicles left: {0}", string.Join(", ", vehicles));
            Console.WriteLine("Vehicles sold: {0}", vehiclesSold.Count);

        }
    }
}
