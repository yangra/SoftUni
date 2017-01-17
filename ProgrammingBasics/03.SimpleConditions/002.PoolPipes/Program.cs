using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _002.PoolPipes
{
    class Program
    {
        static void Main(string[] args)
        {
            int volume = int.Parse(Console.ReadLine());
            int debitP1 = int.Parse(Console.ReadLine());
            int debitP2 = int.Parse(Console.ReadLine());
            double hours = double.Parse(Console.ReadLine());

            double pipe1 = debitP1 * hours;
            double pipe2 = debitP2 * hours;
            double state = (pipe1) + (pipe2);
            
            if (state>volume)
            {
                double overflow = state - volume;
                Console.WriteLine("For {0} hours the pool overflows with {1} liters.",hours, overflow);
            }else
            {
                int perFull = (int)((state / volume) * 100);
                int perP1 = (int)((pipe1 / state) * 100);
                int perP2 = (int)((pipe2 / state) * 100);
                Console.WriteLine("The pool is {0:0}% full. Pipe 1: {1:0}%. Pipe 2: {2:0}%.",perFull,perP1,perP2);
            }

        }
    }
}
