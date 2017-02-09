using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.StudentGroups
{
    public class Town
    {
        public string Name { get; set; }
        public int LabCapacity { get; set; }
        public List<Student> students { get; set; }

        public Town(string name, int capacity)
        {
            this.Name = name;
            this.LabCapacity = capacity;
            this.students = new List<Student>();
        }
    }
}
