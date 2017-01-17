using System;

namespace _02.FlowerShop
{
    class Program
    {
        static void Main(string[] args)
        {
            int magnolias = int.Parse(Console.ReadLine());
            int hyacinths = int.Parse(Console.ReadLine());
            int roses = int.Parse(Console.ReadLine());
            int cacti = int.Parse(Console.ReadLine());
            double giftPrice = double.Parse(Console.ReadLine());

            double order = (magnolias * 3.25 + hyacinths * 4 + roses * 3.5 + cacti * 8) * 0.95;

            if (order>=giftPrice)
            {
                Console.WriteLine("She is left with {0} leva.",Math.Floor(order-giftPrice));
            }
            else
            {
                Console.WriteLine("She will have to borrow {0} leva.", Math.Ceiling(giftPrice-order));
            }
        }
    }
}
