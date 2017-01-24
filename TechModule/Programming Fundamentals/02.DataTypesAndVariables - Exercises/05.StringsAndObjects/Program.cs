using System;

namespace _05.StringsAndObjects
{
    class Program
    {
        static void Main(string[] args)
        {
            string hello = "Hello";
            string world = "World";
            object sentance = hello + " " + world;
            string final = (string)sentance;
            Console.WriteLine(final);
        }
    }
}
