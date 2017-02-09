using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;

namespace _10.StudentGroups
{
    public class StudentGroups
    {
        public static void Main()
        {
            var input = Console.ReadLine();
            var towns = new List<Town>();
            while (input != "End")
            {
                var inputArgs = input.Split(new char[] { '=', '>' }, StringSplitOptions.RemoveEmptyEntries);
                var place = inputArgs[0].Trim();
                var capacityArgs = inputArgs[1].Trim().Split();
                var capacity = int.Parse(capacityArgs[0]);
                Town town = new Town(place, capacity);
                towns.Add(town);
                input = Console.ReadLine();
                while (!input.Contains("seats") && input != "End")
                {
                    var userInfo = input.Split('|');
                    var name = userInfo[0].Trim();
                    var email = userInfo[1].Trim();
                    var entryDate = DateTime.ParseExact(userInfo[2].Trim(), "d-MMM-yyyy", CultureInfo.InvariantCulture);

                    Student student = new Student(name, place, email, entryDate);
                    town.students.Add(student);
                    input = Console.ReadLine();
                }
            }

            var groups = new List<Group>();
            towns = towns.OrderBy(t => t.Name).ToList();
            foreach (var town in towns)
            {
                town.students = town.students
                               .OrderBy(s => s.RegistrationDate)
                               .ThenBy(s => s.Name)
                               .ThenBy(s => s.Email)
                               .ToList();

                var numberOfGroups = 0;
                if (town.students.Count % town.LabCapacity != 0)
                {
                    numberOfGroups = town.students.Count / town.LabCapacity + 1;
                }
                else
                {
                    numberOfGroups = town.students.Count / town.LabCapacity;
                }

                var index = 0;
                for (int i = 0; i < numberOfGroups; i++)
                {
                    var group = new Group();
                    group.Town = town;
                    for (int j = 0; j < town.LabCapacity; j++)
                    {
                        if (index < town.students.Count)
                        {
                            group.Students.Add(town.students[index]);
                            index++;
                        } 
                    }

                    groups.Add(group);
                }
            }

            Console.WriteLine($"Created {groups.Count} groups in {towns.Count} towns:");
            foreach (var town in towns)
            { 
                foreach (var group in groups)
                {
                    if (group.Town == town)
                    {
                        Console.Write($"{town.Name} => ");
                        Console.WriteLine(string.Join(", ", group.Students.Select(s=>s.Email).ToList()));
                    }
                }
            }
        }
    }
}
