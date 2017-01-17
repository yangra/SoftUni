using System;

namespace Vacation
{
    class Program
    {
        static void Main(string[] args)
        {
            int grownUps = int.Parse(Console.ReadLine());
            int students = int.Parse(Console.ReadLine());
            int nights = int.Parse(Console.ReadLine());
            string transport = Console.ReadLine();

            double priceTrGrown = 0;
            double priceTrStudent = 0;

            switch (transport)
            {
                case "train":
                    priceTrGrown = 24.99;
                    priceTrStudent = 14.99;
                    break;
                case "bus":
                    priceTrGrown = 32.50;
                    priceTrStudent = 28.50;
                    break;
                case "boat":
                    priceTrGrown = 42.99;
                    priceTrStudent = 39.99;
                    break;
                case "airplane":
                    priceTrGrown = 70.00;
                    priceTrStudent = 50.00;
                    break;
                default:
                    Console.WriteLine("invalid transport");
                    break;
            }

            double total = 0;
            if (grownUps+students>=50&&transport=="train")
            {
                total = (priceTrStudent*students + priceTrGrown*grownUps +
                    nights*82.99)*1.1;
            }
            else
            {
                total = ((priceTrStudent * students + priceTrGrown * grownUps)*2 +
                    nights * 82.99) * 1.1;
            }

            Console.WriteLine("{0:F2}",total);
        }
    }
}
