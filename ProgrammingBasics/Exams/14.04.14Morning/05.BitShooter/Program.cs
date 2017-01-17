using System;


namespace _05.BitShooter
{
    class Program
    {
        static void Main(string[] args)
        {
            int MaxBit = 64;
            ulong shooter = 0;
            ulong field = ulong.Parse(Console.ReadLine());
            for (int i = 0; i < 3; i++)
            {
                string shot = Console.ReadLine();
                string[] shotStrength = shot.Split(' ');
                int center = int.Parse(shotStrength[0]);
                int size = int.Parse(shotStrength[1]);
                int startBit = center - (size / 2);
                int endBit = center + (size / 2);
                if (startBit<0)
                    startBit = 0;
                if (endBit>=MaxBit)
                    endBit = MaxBit-1;
                for (int bit = startBit; bit <= endBit; bit++)
                {
                    shooter = shooter | ((ulong)1 << bit);
                }

                field = field & (~shooter);
            }

            ulong rightBits = 0;
            for (int i = 0; i < MaxBit/2; i++)
            {
                rightBits += field & 1;
                field >>= 1;
            }
            ulong leftBits = 0;
            for (int i = 0; i < MaxBit / 2; i++)
            {
                leftBits += field & 1;
                field >>= 1;
            }

            Console.WriteLine("left: {0}", leftBits);
            Console.WriteLine("right: {0}",rightBits);
        }
    }
}
