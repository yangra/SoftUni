using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _14.Add15Minutes
{
    class Program
    {
        static void Main(string[] args)
        {
            int hour = int.Parse(Console.ReadLine());
            int minutes = int.Parse(Console.ReadLine());

            minutes += 15;

            if (minutes>=60)
            {
                minutes = minutes % 60;
                hour += 1;
            }
            if (hour>=24)
            {
                hour = 0;
            }

            Console.WriteLine("{0:#0}:{1:00}",hour,minutes);
        }
    }
}
