using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12.Volleyball
{
    class Program
    {
        static void Main(string[] args)
        {
            string year = Console.ReadLine();
            int holidays = int.Parse(Console.ReadLine());
            int homeWeekends = int.Parse(Console.ReadLine());

            double homePlay = homeWeekends;
            double sofiaPlay = (48 - homeWeekends) * 3 / 4.0;
            double holidayPlay = holidays * 2 / 3.0;

            double play = homePlay + sofiaPlay + holidayPlay;
            if (year == "leap")
            {
                play *= 1.15;
            }

            Console.WriteLine(Math.Floor(play));

        }
    }
}
