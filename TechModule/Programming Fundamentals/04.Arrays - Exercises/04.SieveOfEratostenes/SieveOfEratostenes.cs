using System;

class SieveOfEratostenes
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());

        bool[] primes = new bool[n+1];
        for (int i = 2; i < primes.Length; i++)
        {
            primes[i] = true;
        }
        for (int i = 0; i < Math.Sqrt(n+1); i++)
        {
            if (primes[i] == true)
            {
                for (int j = i*i; j < n+1; j+=i)
                {
                    primes[j] = false;
                }
            }
        }

        for (int i = 0; i < primes.Length; i++)
        {
            if (primes[i])
            {
                Console.Write($"{i} ");
            }  
        }
    }
}

