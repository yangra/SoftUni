using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.AndreyAndPool
{
    public class Customer
    {
        public static List<Customer> customers { get; set; }

        public string Name { get; set; }
        public Dictionary<string, int> ShopList { get; set; }
        public decimal Bill { get; set; }

        public static bool ContainsName(string name)
        {
            foreach (var customer in customers)
            {
                if (customer.Name == name)
                {
                    return true;
                }
            }
            return false;
        }

        public void GetSaleData(string product, int quantity)
        {
            if (!ShopList.ContainsKey(product))
            {
                ShopList[product] = 0;
            }

            ShopList[product] += quantity;
        }
    }

}
