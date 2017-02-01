using System;

namespace MethodsAndDebugging
{
    class HelloName
    {
        static void Main()
        {
            string name = Console.ReadLine();
            PrintGreetings(name);
        }

        static void PrintGreetings(string name)
        {
            Console.WriteLine("Hello, {0}!", name);
        }
    }
}
