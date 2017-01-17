using System;

namespace _004.NumberOperations
{
    class Program
    {
        static void Main(string[] args)
        {
            int N1 = int.Parse(Console.ReadLine());
            int N2 = int.Parse(Console.ReadLine());
            char operation = char.Parse(Console.ReadLine());

            double result = 0;
            switch (operation)
            {
                case '+':
                    result = N1 + N2;
                    Console.Write("{0} + {1} = {2}", N1, N2, result);
                    if (result%2==0)
                        Console.WriteLine(" - even");
                    else
                        Console.WriteLine(" - odd");
                    break;
                case '-':
                    result = N1 - N2;
                    Console.Write("{0} - {1} = {2}", N1, N2, result);
                    if (result % 2 == 0)
                        Console.WriteLine(" - even");
                    else
                        Console.WriteLine(" - odd");
                    break;
                case '*':
                    result = N1 * N2;
                    Console.Write("{0} * {1} = {2}", N1, N2, result);
                    if (result % 2 == 0)
                        Console.WriteLine(" - even");
                    else
                        Console.WriteLine(" - odd");
                    break;
                case '/':
                    if (N2!=0)
                    {
                        result = N1 / (double)N2;
                        Console.WriteLine("{0} / {1} = {2:f2}", N1, N2, result);
                    }
                    else
                        Console.WriteLine("Cannot divide {0} by zero",N1);
                    break;
                case '%':
                    if (N2!=0)
                    {
                        result = N1 % N2;
                        Console.WriteLine("{0} % {1} = {2}", N1, N2, result);
                    }
                    else
                        Console.WriteLine("Cannot divide {0} by zero", N1);

                    break;
                default:
                    Console.WriteLine("Undefined operation");
                    break;
            }
        }
    }
}
