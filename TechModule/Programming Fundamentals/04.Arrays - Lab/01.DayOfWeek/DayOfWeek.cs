using System;

class DayOfWeek
{
    static void Main(string[] args)
    {
        string[] daysOfWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

        int input = int.Parse(Console.ReadLine());
        if (input >= 1 && input <= daysOfWeek.Length)
        {
            Console.WriteLine(daysOfWeek[input - 1]);
        }
        else
        {
            Console.WriteLine("Invalid Day!");
        }
    }
}

