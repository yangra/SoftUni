using System;

namespace _03.HotelRoom
{
    class Program
    {
        static void Main(string[] args)
        {
            string month = Console.ReadLine();
            int nights = int.Parse(Console.ReadLine());

            double appPrice = 0;
            double studioPrice = 0;
            if (month=="May"||month=="October")
            {
                if (nights<=7)
                {
                    appPrice = nights * 65;
                    studioPrice = nights * 50;
                }
                else if(nights>7&&nights<=14)
                {
                    appPrice = nights * 65;
                    studioPrice = (nights * 50)*0.95;
                }
                else if (nights>14)
                {
                    appPrice = (nights * 65) * 0.9;
                    studioPrice = (nights * 50) * 0.7;
                }
            }
            else if (month == "June" || month == "September")
            {
                if (nights <= 14)
                {
                    appPrice = nights * 68.7;
                    studioPrice = nights * 75.2;
                }
                else if (nights > 14)
                {
                    appPrice = (nights * 68.7) * 0.9;
                    studioPrice = (nights * 75.2) * 0.8;
                }
            }
            else if (month == "July" || month == "August")
            {
                if (nights <= 14)
                {
                    appPrice = nights * 77;
                    studioPrice = nights * 76;
                }
                else if (nights > 14)
                {
                    appPrice = (nights * 77) * 0.9;
                    studioPrice = nights * 76;
                }

            }

            Console.WriteLine("Apartment: {0:f2} lv.",appPrice);
            Console.WriteLine("Studio: {0:f2} lv.",studioPrice);
        }
    }
}
