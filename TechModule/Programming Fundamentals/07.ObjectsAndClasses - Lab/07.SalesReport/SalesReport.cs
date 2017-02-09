using System;
using System.Collections.Generic;

namespace _07.SalesReport
{
    public class SalesReport
    {
        public static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            var salesInfo = new List<Sale>();
            for (int i = 0; i < n; i++)
            {
                var currentSale = ReadSale();
                salesInfo.Add(currentSale);
            }

            var salesByTown = new SortedDictionary<string, decimal>();
            foreach (var sale in salesInfo)
            {
                if (!salesByTown.ContainsKey(sale.Town))
                {
                    salesByTown[sale.Town] = 0m;
                }

                salesByTown[sale.Town] += sale.Total;
            }

            foreach (var town in salesByTown)
            {
                Console.WriteLine($"{town.Key} -> {town.Value:F2}");
            }
        }

        public static Sale ReadSale()
        {
            var saleArgs = Console.ReadLine().Split(' ');
            Sale sale = new Sale
            {
                Town = saleArgs[0],
                Product = saleArgs[1],
                Price = decimal.Parse(saleArgs[2]),
                Quantity = decimal.Parse(saleArgs[3])
            };

            return sale;
        }
    }
}
