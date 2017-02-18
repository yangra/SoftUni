using System;
using System.Collections.Generic;
using System.Linq;

namespace _03.MatrixOperator
{
    public class MatrixOperator
    {
        public static void Main()
        {
            int numberOfRows = int.Parse(Console.ReadLine());
            var matrix = new List<List<int>>();
            for (int i = 0; i < numberOfRows; i++)
            {
                matrix.Add( Console.ReadLine().Split(' ').Select(int.Parse).ToList());
            }

            string input = Console.ReadLine();
            while (input != "end")
            {
                string[] inputArgs = input.Split(' ');
                switch (inputArgs[0])
                {
                    case "remove": RemoveElements(matrix, inputArgs); break;
                    case "swap": SwapRows(matrix, inputArgs); break;
                    case "insert": InsertElement(matrix, inputArgs); break;
                    default: break;
                }

                input = Console.ReadLine();
            }

            foreach (var item in matrix)
            {
                Console.WriteLine(string.Join(" ", item));
            }
        }

        private static void SwapRows(List<List<int>> matrix, string[] inputArgs)
        {
            int indexOne = int.Parse(inputArgs[1]);
            int indexTwo = int.Parse(inputArgs[2]);
            List<int> temp = matrix[indexOne];
            matrix[indexOne] = matrix[indexTwo];
            matrix[indexTwo] = temp;
        }

        private static void InsertElement(List<List<int>> matrix, string[] inputArgs)
        {
            int row = int.Parse(inputArgs[1]);
            int element = int.Parse(inputArgs[2]);
            matrix[row].Insert(0, element);
        }

        private static void RemoveElements(List<List<int>> matrix, string[] inputArgs)
        {
            string type = inputArgs[1];
            string rowCol = inputArgs[2];
            int index = int.Parse(inputArgs[3]);

            if (rowCol == "row")
            {
                switch (type)
                {
                    case "positive":
                        matrix[index] = matrix[index].Where(n => n < 0).ToList();
                        break;
                    case "negative":
                        matrix[index] = matrix[index].Where(n => n >= 0).ToList();
                        break;
                    case "odd":
                        matrix[index] = matrix[index].Where(n => n % 2 == 0).ToList();
                        break;
                    case "even":
                        matrix[index] = matrix[index].Where(n => n % 2 != 0).ToList();
                        break;
                    default:
                        break;
                }
            }
            else if (rowCol == "col")
            {
                switch (type)
                {
                    case "positive":
                        {
                            for (int currRow = 0; currRow < matrix.Count; currRow++)
                            {
                                if (index >= matrix[currRow].Count)
                                {
                                    continue;
                                }
                                if (matrix[currRow][index] >= 0)
                                {
                                    matrix[currRow].RemoveAt(index);
                                }
                            }
                            break;
                        }
                    case "negative":
                        {
                            for (int currRow = 0; currRow < matrix.Count; currRow++)
                            {
                                if (index >= matrix[currRow].Count)
                                {
                                    continue;
                                }
                                if (matrix[currRow][index] < 0)
                                {
                                    matrix[currRow].RemoveAt(index);
                                }
                            }
                            break;
                        }
                    case "odd":
                        {
                            for (int currRow = 0; currRow < matrix.Count; currRow++)
                            {
                                if (index >= matrix[currRow].Count)
                                {
                                    continue;
                                }
                                if (matrix[currRow][index] % 2 != 0)
                                {
                                    matrix[currRow].RemoveAt(index);
                                }
                            }
                            break;
                        };
                    case "even":
                        {
                            for (int currRow = 0; currRow < matrix.Count; currRow++)
                            {
                                if (index >= matrix[currRow].Count)
                                {
                                    continue;
                                }
                                if (matrix[currRow][index] % 2 == 0)
                                {
                                    matrix[currRow].RemoveAt(index);
                                }
                            }
                            break;
                        }
                }
            }
        }
    }
}

