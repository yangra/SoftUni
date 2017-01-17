using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.FiveSpecialLetters
{
    class Program
    {
        static void Main(string[] args)
        {
            int start = int.Parse(Console.ReadLine());
            int end = int.Parse(Console.ReadLine());

            bool exist = false;
            string set = "";
            for (char i = 'a'; i < 'f'; i++)
            {
                for (char j = 'a'; j < 'f'; j++)
                {
                    for (char k = 'a'; k < 'f'; k++)
                    {
                        for (char m = 'a'; m < 'f'; m++)
                        {
                            for (char n = 'a'; n < 'f'; n++)
                            {
                                set += i;
                                set += j;
                                set += k;
                                set += m;
                                set += n;
                                char[] distinct = set.Distinct().ToArray();

                                int setWeight = GetWeight(distinct);

                                if (setWeight<=end&&setWeight>=start)
                                {
                                    exist = true;
                                    Console.Write(set + " ");
                                }
                                set = "";
                            }
                        }
                    }
                }

            }

            if (!exist)
            {
                Console.Write("No");
            }
        }

        static int GetWeight(char[] abc)
        {
            bool[] flags = new bool[5];
            for (int i = 0; i < 5; i++)
            {
                flags[i] = false;
            }
            int weight = 0;
            for (int i = 0; i < abc.Length; i++)
            {
                weight += (i + 1) * GetSingleWeight(abc[i], flags);
            }
            return weight;   
           
        }

        static int GetSingleWeight(char letter,bool[] flags)
        {
            switch (letter)
            {
                case 'a':
                    if (flags[0])
                        return 0;
                    flags[0] = true;
                    return 5; 
                case 'b':
                    if (flags[1])
                        return 0;
                    flags[1] = true;
                    return -12; 
                case 'c':
                    if (flags[2])
                        return 0;
                    flags[2] = true;
                    return 47; 
                case 'd':
                    if (flags[3])
                        return 0;
                    flags[3] = true;
                    return 7; 
                case 'e':
                    if (flags[4])
                        return 0;
                    flags[4] = true;
                    return -32; 
                default: return 0; 
            }
        }
    }
}
