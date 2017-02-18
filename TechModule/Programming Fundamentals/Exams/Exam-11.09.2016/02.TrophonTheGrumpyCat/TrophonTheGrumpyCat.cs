using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.TrophonTheGrumpyCat
{
    public class TrophonTheGrumpyCat
    {
        public static void Main()
        {
            var ratings = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            var entry = long.Parse(Console.ReadLine());
            var typeOfItems = Console.ReadLine();
            var typeOfRatings = Console.ReadLine();

            long damageLeft = 0;
            for (long i = 0; i < entry; i++)
            {
                if (BreakItem(ratings[entry], ratings[i], typeOfItems, typeOfRatings))
                {
                    damageLeft += ratings[i];
                }
            }
            long damageRight = 0;
            for (long i = entry + 1; i < ratings.Length; i++)
            {
                if (BreakItem(ratings[entry], ratings[i], typeOfItems, typeOfRatings))
                {
                    damageRight += ratings[i];
                }
            }

            if (damageLeft == damageRight)
            {
                Console.WriteLine($"Left - {damageLeft}");
            }
            else if (damageLeft > damageRight)
            {
                Console.WriteLine($"Left - {damageLeft}");
            }
            else
            {
                Console.WriteLine($"Right - {damageRight}");
            }
        }

        public static bool BreakItem(long entry, int item, string typeOfItems, string typeOfRatings)
        {
            if (typeOfItems == "cheap")
            {
                if (typeOfRatings == "positive")
                {
                    if (item > 0 && item < entry)
                    {
                        return true;
                    }
                    return false;
                }
                else if (typeOfRatings == "negative")
                {
                    if (item < 0 && item < entry)
                    {
                        return true;
                    }
                    return false;
                }
                else
                {
                    if (item < entry)
                    {
                        return true;
                    }
                    return false;
                }
            }
            else
            {
                if (typeOfRatings == "positive")
                {
                    if (item > 0 && item >= entry)
                    {
                        return true;
                    }
                    return false;
                }
                else if (typeOfRatings == "negative")
                {
                    if (item < 0 && item >= entry)
                    {
                        return true;
                    }
                    return false;
                }
                else
                {
                    if (item >= entry)
                    {
                        return true;
                    }
                    return false;
                }
            }

        }
    }
}
