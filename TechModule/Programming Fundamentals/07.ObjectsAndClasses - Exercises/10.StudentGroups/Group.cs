using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.StudentGroups
{
    public class Group
    {
        public Town Town { get; set; }
        public List<Student> Students { get; set; }

        public Group()
        {
            Students = new List<Student>();
        }
    }
}
