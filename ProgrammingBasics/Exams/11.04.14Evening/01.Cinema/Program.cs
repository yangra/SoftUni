using System;


namespace _01.Cinema
{
    class Program
    {
        static void Main(string[] args)
        {
            string type = Console.ReadLine();
            int numRows = int.Parse(Console.ReadLine());
            int numCols = int.Parse(Console.ReadLine());

            double price = 0;

            switch (type)
            {
                case "Premiere":
                    price = 12;
                    break;
                case "Normal":
                    price = 7.5;
                    break;
                case "Discount":
                    price = 5;
                    break;
            }

            double total = numRows * numCols * price;
            Console.WriteLine("{0:F2} leva", total);
        }
    }
}
