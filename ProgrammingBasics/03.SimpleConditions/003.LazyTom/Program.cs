using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _003.LazyTom
{
    class Program
    {
        static void Main(string[] args)
        {
            int holidays = int.Parse(Console.ReadLine());

            int playTime = (holidays * 127) + ((365 - holidays) * 63);

            if (playTime>30000)
            {
                int overTime = playTime - 30000;
                Console.WriteLine("Tom will run away");
                Console.WriteLine("{0} hours and {1} minutes more for play",overTime/60,overTime%60);
            }
            if (playTime < 30000)
            {
                int lessTime = 30000 - playTime;
                Console.WriteLine("Tom sleeps well");
                Console.WriteLine("{0} hours and {1} minutes less for play", lessTime / 60, lessTime % 60);
            }
        }
    }
}
