using System;

namespace _06.MaxCombination
{
    class Program
    {
        static void Main(string[] args)
        {
            int start = int.Parse(Console.ReadLine());
            int end = int.Parse(Console.ReadLine());
            int maxNum = int.Parse(Console.ReadLine());
            int counter = 0;
            for (int i = start; i <= end; i++)
            {
                for (int j = start; j <= end; j++)
                {
                    Console.Write("<{0}-{1}>",i,j);
                    counter++;
                    if(counter==maxNum)
                    {
                        break;
                    }
                }
                if (counter == maxNum)
                {
                    break;
                }
            }
        }
    }
}
