using System;
using System.Collections.Generic;
using System.Linq;

namespace _02.SoftUniWaterSupplies
{
    public class SoftUniWaterSupplies
    {
        public static void Main()
        {
            decimal totalWater = decimal.Parse(Console.ReadLine());
            decimal[] bottles = Console.ReadLine().Split(' ').Select(decimal.Parse).ToArray();
            decimal bottleCapacity = decimal.Parse(Console.ReadLine());

            decimal waterInBottles = bottles.Sum();
            decimal waterNeeded = bottles.Length * bottleCapacity - waterInBottles;
            if (totalWater - waterNeeded >= 0)
            {
                Console.WriteLine("Enough water!");
                Console.WriteLine("Water left: {0}l.", totalWater - waterNeeded);
            }
            else
            {
                Console.WriteLine("We need more water!");

                decimal waterLeft = totalWater;
                int bottlesLeft = 0;
                List<int> indexes = new List<int>();
                if (totalWater % 2 == 0)
                {
                    for (int i = 0; i < bottles.Length; i++)
                    {
                        waterLeft -= (bottleCapacity - bottles[i]);
                        if (waterLeft < 0)
                        {
                            bottlesLeft++;
                            indexes.Add(i);
                        }
                    }
                }
                else
                {
                    for (int i = bottles.Length - 1; i >= 0; i--)
                    {
                        waterLeft -= (bottleCapacity - bottles[i]);
                        if (waterLeft < 0)
                        {
                            bottlesLeft++;
                            indexes.Add(i);
                        }
                    }
                }

                Console.WriteLine("Bottles left: {0}", bottlesLeft);
                Console.WriteLine("With indexes: {0}", string.Join(", ", indexes));
                Console.WriteLine("We need {0} more liters!", Math.Abs(waterLeft));
            }
        }
    }
}
