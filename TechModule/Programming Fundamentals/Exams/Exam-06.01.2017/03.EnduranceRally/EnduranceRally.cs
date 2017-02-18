using System;
using System.Collections.Generic;
using System.Linq;

namespace _03.EnduranceRally
{
    public class EnduranceRally
    {
        public static void Main()
        {
            var drivers = Console.ReadLine().Split();
            var zones = Console.ReadLine().Split().Select(double.Parse).ToArray();
            var checkpoints = Console.ReadLine().Split().Select(int.Parse).ToArray();

            var result = new List<Driver>();
            for (int i = 0; i < drivers.Length; i++)
            {
                var driverName = drivers[i];
                double fuel = driverName[0];
                var driver = new Driver
                {
                    Name = driverName,
                    Fuel = fuel
                };
                result.Add(driver);
                for (int j = 0; j < zones.Length; j++)
                {
                    if (checkpoints.Contains(j))
                    {
                        driver.Fuel += zones[j];
                    }
                    else
                    {
                        driver.Fuel -= zones[j];
                    }

                    if (driver.Fuel<=0)
                    {
                        driver.Zone = j;
                        break;
                    }
                }
            }

            for (int i = 0; i < result.Count; i++)
            {
                var driver = result[i];
                if (driver.Fuel>0)
                {
                    Console.WriteLine("{0} - fuel left {1:F2}", driver.Name, driver.Fuel);
                }
                else
                {
                    Console.WriteLine("{0} - reached {1}",driver.Name, driver.Zone);
                }
                
            }
        }
    }
}
