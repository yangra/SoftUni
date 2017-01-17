using System;

namespace _001.OnTimeForExam
{
    class Program
    {
        static void Main(string[] args)
        {
            int hourExam = int.Parse(Console.ReadLine());
            int minutesExam = int.Parse(Console.ReadLine());
            int hourArrive = int.Parse(Console.ReadLine());
            int minutesArrive = int.Parse(Console.ReadLine());

            int examTime = hourExam * 60 + minutesExam;
            int arrivalTime = hourArrive * 60 + minutesArrive;
            int timeDiff = examTime - arrivalTime;

            if (timeDiff <= 30 && timeDiff >= 0)
            {
                Console.WriteLine("On time");
            }
            else if (timeDiff < 0)
            {
                Console.WriteLine("Late");
            }
            else if (timeDiff > 30)
            {
                Console.WriteLine("Early");
            }

            if (timeDiff!=0)
            {
                int minutes = Math.Abs(timeDiff % 60);
                int hours = Math.Abs(timeDiff / 60);
                if (hours>0)
                {
                    Console.Write("{0:##}:{1:00} hours",hours,minutes);
                }
                else
                {
                    Console.Write("{0} minutes",minutes);
                }

                if (timeDiff<0)
                {
                    Console.WriteLine(" after the start");
                }
                else
                {
                    Console.WriteLine(" before the start");
                }
            }

        }
    }
}
