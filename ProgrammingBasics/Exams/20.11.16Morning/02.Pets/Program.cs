using System;


namespace _02.Pets
{
    class Program
    {
        static void Main(string[] args)
        {
            int days = int.Parse(Console.ReadLine());
            int kgFood = int.Parse(Console.ReadLine());
            double kgDogDay = double.Parse(Console.ReadLine());
            double kgCatDay = double.Parse(Console.ReadLine());
            double gTurtleDay = double.Parse(Console.ReadLine());

            double foodPerDay = kgCatDay + kgDogDay + (gTurtleDay / 1000);
            double foodNeeded = days * foodPerDay;

            if (foodNeeded<=kgFood)
            {
                Console.WriteLine("{0} kilos of food left.", Math.Floor(kgFood-foodNeeded));
            }
            else
            {
                Console.WriteLine("{0} more kilos of food are needed.", Math.Ceiling(foodNeeded-kgFood));
            }
        }
    }
}
