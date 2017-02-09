using System;
using System.Collections.Generic;
using System.Linq;

namespace _07.AndreyAndPool
{
    public class AndreyAndPool
    {
        public static void Main()
        {
            var shop = new Dictionary<string, decimal>();
            int entries = int.Parse(Console.ReadLine());
            for (int i = 0; i < entries; i++)
            {
                var input = Console.ReadLine().Split('-');
                var name = input[0];
                var price = decimal.Parse(input[1]);

                if (!shop.ContainsKey(name))
                {
                    shop[name] = 0m;
                }

                shop[name] = price;
            }

            Customer.customers = new List<Customer>();

            var buyer = Console.ReadLine();
            while (buyer != "end of clients")
            {
                var buyerArgs = buyer.Split(new char[] { '-', ',' }, StringSplitOptions.RemoveEmptyEntries);
                var name = buyerArgs[0];
                var product = buyerArgs[1];
                var quantity = int.Parse(buyerArgs[2]);
                if (shop.ContainsKey(product))
                {
                    if (!Customer.ContainsName(name))
                    {
                        Customer customer = new Customer
                        {
                            Name = name,
                            ShopList = new Dictionary<string, int>()
                        };

                        customer.GetSaleData(product, quantity);
                        Customer.customers.Add(customer);
                    }
                    else
                    {
                        foreach (var customer in Customer.customers)
                        {
                            if (customer.Name == name)
                            {
                                customer.GetSaleData(product, quantity);
                            }
                        }
                    }  
                }

                buyer = Console.ReadLine(); 
            }

            foreach (var customer in Customer.customers)
            {
                foreach (var sale in customer.ShopList)
                {
                    foreach (var item in shop)
                    {
                        if (sale.Key == item.Key)
                        {
                            customer.Bill += sale.Value * item.Value;
                        } 
                    }
                }
            }

            var totalBill = 0m;
            var orderedCustomers = Customer.customers.OrderBy(c => c.Name).ToArray();
            foreach (var customer in orderedCustomers)
            {
                Console.WriteLine(customer.Name);
                foreach (var sale in customer.ShopList)
                {
                    Console.WriteLine($"-- {sale.Key} - {sale.Value}");
                }
                Console.WriteLine($"Bill: {customer.Bill:F2}");
                totalBill += customer.Bill;
            }

            Console.WriteLine("Total bill: {0:F2}", totalBill);
        }
    }
}
