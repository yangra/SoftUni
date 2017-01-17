using System;

namespace _08.TradeCommission
{
    class Program
    {
        static void Main(string[] args)
        {
            string town = Console.ReadLine();
            double amount = double.Parse(Console.ReadLine());

            double commission = 0;

            if (town == "Sofia")
            {
                commission = calcCommission(amount, 0.05, 0.07, 0.08, 0.12);
            }
            else if (town == "Plovdiv")
            {
                commission = calcCommission(amount, 0.055, 0.08, 0.12, 0.145);
            }
            else if (town == "Varna")
            {
                commission = calcCommission(amount, 0.045, 0.075, 0.1, 0.13);
               
            }
            else
            {
                Console.WriteLine("error");
            }


            if (commission!=0)
            {
                Console.WriteLine("{0:F2}", amount * commission);
            }
            
        }

        static double calcCommission(double sales,double a, double b, double c, double d)
        {
            if (sales >= 0 && sales <= 500) return a;
            else if (sales > 500 && sales <= 1000) return b;
            else if (sales > 1000 && sales <= 10000) return c;
            else if (sales > 10000) return d;
            else { Console.WriteLine("error"); return 0; }
        }
    }
}
