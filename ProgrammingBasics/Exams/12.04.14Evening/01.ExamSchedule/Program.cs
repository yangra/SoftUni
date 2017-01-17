using System;


namespace _01.ExamSchedule
{
    class Program
    {
        static void Main(string[] args)
        {
            int startHour = int.Parse(Console.ReadLine());
            int startMinutes = int.Parse(Console.ReadLine());
            string startPartDay = Console.ReadLine();
            int durHours = int.Parse(Console.ReadLine());
            int durMinutes = int.Parse(Console.ReadLine());

            int endHour = 0;
            int endMinutes = ((startMinutes + durMinutes) % 60);
            string endPartDay = startPartDay;

            if ((startMinutes + durMinutes) / 60 == 1)
            {
                endHour = 1;
            }

            int hours = endHour + startHour + durHours;
            endHour += (startHour + durHours) % 12;

            if ((hours) / 12 == 1)
            {
                if (startPartDay == "PM")
                    endPartDay = "AM";
                if (startPartDay == "AM")
                    endPartDay = "PM";
            }
            Console.Write("{0:00}:{1:00}:{2}", endHour, endMinutes, endPartDay);
        }
    }
}
