using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class CountNumbers
{
    static void Main()
    {
        List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
        numbers.Sort();
        int pos = 0;
        while (pos < numbers.Count)
        {
            int num = numbers[pos];
            int count = 0;
            while (pos + count < numbers.Count && numbers[pos + count] == num)
            {
                count++;
            }
            Console.WriteLine($"{numbers[pos]} -> {count}");
            pos = pos + count;
        }
    }
}

