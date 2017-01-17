using System;
using System.Globalization;


namespace _13.Add1000days
{
    class Program
    {
        static void Main(string[] args)
        {
            var birthDate = DateTime.ParseExact(Console.ReadLine(), "dd-MM-yyyy",CultureInfo.InvariantCulture);

            var thousandDaysAfterBirthdate = birthDate.AddDays(999);

            Console.WriteLine(thousandDaysAfterBirthdate.ToString("dd-MM-yyyy"));
        }
    }
}
