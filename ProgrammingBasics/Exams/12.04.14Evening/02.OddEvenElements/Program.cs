using System;

namespace _02.OddEvenElements
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                string input = Console.ReadLine();


                string[] numbers = input.Split(' ');

                double oddSum = 0;
                double oddMax = 0;
                double oddMin = 0;
                double evenSum = 0;
                double evenMax = 0;
                double evenMin = 0;
                bool isThereEven = false;
                bool isThereOdd = false;

                for (int odd = 0; odd < numbers.Length; odd += 2)
                {
                    double oddNumber = double.Parse(numbers[odd]);
                    oddSum += oddNumber;
                    if (odd == 0)
                    {
                        isThereOdd = true;
                        oddMax = oddNumber;
                        oddMin = oddNumber;
                        continue;
                    }
                    if (oddNumber > oddMax)
                    {
                        oddMax = oddNumber;
                    }
                    if (oddMin > oddNumber)
                    {
                        oddMin = oddNumber;
                    }

                }
                for (int even = 1; even < numbers.Length; even += 2)
                {
                    double evenNumber = double.Parse(numbers[even]);
                    evenSum += evenNumber;
                    if (even == 1)
                    {
                        isThereEven = true;
                        evenMax = evenNumber;
                        evenMin = evenNumber;
                        continue;
                    }
                    if (evenNumber > evenMax)
                    {
                        evenMax = evenNumber;
                    }
                    if (evenMin > evenNumber)
                    {
                        evenMin = evenNumber;
                    }

                }
                if (isThereEven && isThereOdd)
                {
                    Console.Write("OddSum={0:0.##}, OddMin={1:0.##}, OddMax={2:0.##}, EvenSum={3:0.##}, EvenMin={4:0.##}, EvenMax={5:0.##}"
                                                , oddSum, oddMin, oddMax, evenSum, evenMin, evenMax);
                }
                else
                {
                    Console.Write("OddSum={0:0.##}, OddMin={1:0.##}, OddMax={2:0.##}, EvenSum=No, EvenMin=No, EvenMax=No"
                                    , oddSum, oddMin, oddMax);
                }
            }
            catch (System.FormatException)
            {
                Console.WriteLine("OddSum=No, OddMin=No, OddMax=No, EvenSum=No, EvenMin=No, EvenMax=No");

            }
        }
    }
}
