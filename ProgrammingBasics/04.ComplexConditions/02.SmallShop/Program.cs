using System;


namespace _02.SmallShop
{
    class Program
    {
        static void Main(string[] args)
        {
            string product = Console.ReadLine();
            string town = Console.ReadLine();
            double quantity = double.Parse(Console.ReadLine());

            double[,] price = {
                    {0.5,0.8,1.2,1.45,1.6},
                    {0.4,0.7,1.15,1.30,1.5},
                    {0.45,0.7,1.1,1.35,1.55},
                };
            int row = 0;
            int col = 0;
            switch (town)
            {
                case "Sofia": row = 0; break;
                case "Plovdiv": row = 1; break;
                case "Varna": row = 2; break;
                default: Console.WriteLine("You have entered an invalid town"); break;
            }
            switch (product)
            {
                case "coffee": col = 0; break;
                case "water": col = 1; break;
                case "beer": col = 2; break;
                case "sweets": col = 3; break;
                case "peanuts": col = 4; break;
                default: Console.WriteLine("You have etered an invalid product"); break;
            }

            Console.WriteLine(quantity*price[row,col]);
        }
    }
}
