﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.BonusPoints
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
            double bonus = 0;

            if (num%2==0)
            {
                bonus += 1;
            }
            else if((num-5)%10==0)
            {
                bonus += 2;
            }

            if (num<=100)
            {
                bonus += 5;
            }else if (num>100&&num<=1000)
            {
                bonus += num * 0.2;
            }else if (num>1000)
            {
                bonus += num * 0.1;
            }

            Console.WriteLine(bonus);
            Console.WriteLine(num+bonus);
        }
    }
}
