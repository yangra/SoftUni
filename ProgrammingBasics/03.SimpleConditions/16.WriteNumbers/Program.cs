using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _16.WriteNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());

            if(number<0||number>100)
            {
                Console.WriteLine("invalid number");
            }

            if (number == 0)
                Console.WriteLine("zero");

            if (number > 20 && number < 30)
            {
                Console.Write("twenty ");
                number %= 20;
            }

            if (number > 30 && number < 40)
            {
                Console.Write("thirty ");
                number %= 30;
            }

            if (number > 40 && number < 50)
            {
                Console.Write("fourty ");
                number %= 40;
            }

            if (number > 50 && number < 60)
            {
                Console.Write("fifty ");
                number %= 50;
            }

            if (number > 60 && number < 70)
            {
                Console.Write("sixty ");
                number %= 60;
            }

            if (number > 70 && number < 80)
            {
                Console.Write("seventy ");
                number %= 70;
            }

            if (number > 80 && number < 90)
            {
                Console.Write("eighty ");
                number %= 80;
            }

            if (number > 90 && number < 100)
            {
                Console.Write("ninety ");
                number %= 90;
            }

            
            if (number == 1)
                Console.WriteLine("one");
            else if (number == 2)
                Console.WriteLine("two");
            else if (number == 3)
                Console.WriteLine("three");
            else if (number == 4)
                Console.WriteLine("four");
            else if (number == 5)
                Console.WriteLine("five");
            else if (number == 6)
                Console.WriteLine("six");
            else if (number == 7)
                Console.WriteLine("seven");
            else if (number == 8)
                Console.WriteLine("eight");
            else if (number == 9)
                Console.WriteLine("nine");
            else if (number == 10)
                Console.WriteLine("ten");
            else if (number == 11)
                Console.WriteLine("eleven");
            else if (number == 12)
                Console.WriteLine("twelve");
            else if (number == 13)
                Console.WriteLine("thirteen");
            else if (number == 14)
                Console.WriteLine("fourteen");
            else if (number == 15)
                Console.WriteLine("fifteen");
            else if (number == 16)
                Console.WriteLine("sixteen");
            else if (number == 17)
                Console.WriteLine("seventeen");
            else if (number == 18)
                Console.WriteLine("eighteen");
            else if (number == 19)
                Console.WriteLine("nineteen");
            else if (number == 100)
                Console.WriteLine("one hundred");
            else if (number == 20)
                Console.WriteLine("twenty");
            else if (number == 30)
                Console.WriteLine("thirty");
            else if (number == 40)
                Console.WriteLine("fourty");
            else if (number == 50)
                Console.WriteLine("fifty");
            else if (number == 60)
                Console.WriteLine("sixty");
            else if (number == 70)
                Console.WriteLine("seventy");
            else if (number == 80)
                Console.WriteLine("eighty");
            else if (number == 90)
                Console.WriteLine("ninety");


        }
    }
}
