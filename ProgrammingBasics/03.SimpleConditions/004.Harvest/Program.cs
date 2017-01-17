using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _004.Harvest
{
    class Program
    {
        static void Main(string[] args)
        {
            int sqM = int.Parse(Console.ReadLine());
            double grapeSqM = double.Parse(Console.ReadLine());
            int neededLitres = int.Parse(Console.ReadLine());
            int workers = int.Parse(Console.ReadLine());

            double totalGrape = grapeSqM * sqM;
            double wine = (0.4 * totalGrape) / 2.5;

            if (wine >= neededLitres)
            {
                double wineLeft = Math.Ceiling(wine - neededLitres);
                double perWorker = Math.Ceiling(wineLeft / workers);
                Console.WriteLine("Good harvest this year! Total wine: {0} liters.", Math.Floor(wine));
                Console.WriteLine("{0} liters left -> {1} liters per person.", wineLeft, perWorker);
            }
            if (wine < neededLitres)
            {
                Console.WriteLine("It will be a tough winter! More {0} liters wine needed.", Math.Floor(neededLitres - wine));
            }
        }
    }
}
