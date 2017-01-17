using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FruitMarket
{
    class Program
    {
        static decimal priceBanana = 1.80m;
        static decimal priceCucumber = 2.75m;
        static decimal priceTomato = 3.20m;
        static decimal priceOrange = 1.60m;
        static decimal priceApple = 0.86m;
        static decimal total = 0;

        static void Main(string[] args)
        {
 
            string day = Console.ReadLine();

            decimal quantity1 = decimal.Parse(Console.ReadLine());
            string product1 = Console.ReadLine();
            decimal quantity2 = decimal.Parse(Console.ReadLine());
            string product2 = Console.ReadLine();
            decimal quantity3 = decimal.Parse(Console.ReadLine());
            string product3 = Console.ReadLine();

            addProduct(product1, quantity1,day);
            addProduct(product2, quantity2,day);
            addProduct(product3, quantity3,day);

            if (day == "Friday")
            {
                total -= total / 10;
            }

            if (day == "Sunday")
            {
                total -= total / 20;
            }


            Console.WriteLine(Math.Round(total,2));

        }

        static void addProduct(string prod,decimal quantity,string weekDay)
        {
            switch (prod)
            {
                case "apple":
                    if(weekDay == "Tuesday")
                        total += quantity * 0.8m * priceApple;
                    else
                        total += quantity * priceApple;
                    break;
                case "banana":
                    if (weekDay == "Tuesday")
                        total += quantity * 0.8m * priceBanana;
                    else if (weekDay == "Thursday")
                        total += quantity * 0.7m * priceBanana;
                    else
                        total += quantity * priceBanana;
                    break;
                case "tomato":
                    if (weekDay == "Wednesday")
                        total += quantity * 0.9m * priceTomato;
                    else
                        total += quantity * priceTomato;
                    break;
                case "cucumber":
                    if (weekDay == "Wednesday")
                        total += quantity * 0.9m * priceCucumber;
                    else
                        total += quantity * priceCucumber;
                    break;
                case "orange":
                    if (weekDay == "Tuesday")
                        total += quantity * 0.8m * priceOrange;
                    else
                        total += quantity * priceOrange;
                    break;
                default: Console.WriteLine("There is a mistake");
                    
                    break;
            }
            
         }

    }
}
