using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Nacepin
{
    public class Nacepin
    {
        public static void Main()
        {
            var USPrice = decimal.Parse(Console.ReadLine());
            var USkg = long.Parse(Console.ReadLine());
            var UKPrice = decimal.Parse(Console.ReadLine());
            var UKkg = long.Parse(Console.ReadLine());
            var CnPrice = decimal.Parse(Console.ReadLine());
            var CnKg = long.Parse(Console.ReadLine());

            var USPricePerKilo = USPrice / USkg;
            var UKPricePerKilo = UKPrice / UKkg;
            var CnPricePerKilo = CnPrice / CnKg;

            var USkglv = USPricePerKilo / 0.58m;
            var UKkglv = UKPricePerKilo / 0.41m;
            var CNkglv = CnPricePerKilo * 0.27m;

            if (USkglv<UKkglv&&USkglv<CNkglv)
            {
                Console.WriteLine("US store. {0:F2} lv/kg", USkglv);
                if (UKkglv>CNkglv)
                {
                    Console.WriteLine("Difference {0:F2} lv/kg", UKkglv-USkglv);
                }
                else
                {
                    Console.WriteLine("Difference {0:F2} lv/kg", CNkglv - USkglv);
                }
            }
            else if (UKkglv < USkglv && UKkglv < CNkglv)
            {
                Console.WriteLine("UK store. {0:F2} lv/kg", UKkglv);
                if (USkglv > CNkglv)
                {
                    Console.WriteLine("Difference {0:F2} lv/kg", USkglv - UKkglv);
                }
                else
                {
                    Console.WriteLine("Difference {0:F2} lv/kg", CNkglv - UKkglv);
                }
            }
            else if (CNkglv < USkglv && CNkglv < UKkglv)
            {
                Console.WriteLine("Chinese store. {0:F2} lv/kg", CNkglv);
                if (USkglv > UKkglv)
                {
                    Console.WriteLine("Difference {0:F2} lv/kg", USkglv - CNkglv);
                }
                else
                {
                    Console.WriteLine("Difference {0:F2} lv/kg", UKkglv - CNkglv);
                }
            }

        }
    }
}
