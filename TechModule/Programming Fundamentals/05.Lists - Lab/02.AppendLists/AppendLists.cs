using System;
using System.Collections.Generic;

class AppendLists
{
    static void Main()
    {
        string[] lists = Console.ReadLine().Split('|');
        List<int> appended = new List<int>();
        for (int i = 0; i < lists.Length; i++)
        {
            string[] list = lists[lists.Length - 1 - i].Trim().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            foreach (var num in list)
            {
                appended.Add(int.Parse(num));
            }
        }

        Console.WriteLine(string.Join(" ", appended));
    }
}

