using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.TeamworkProjects
{
    public class Team
    {
        public string Name { get; set; }
        public string Creator { get; set; }
        public List<User> Members { get; set; }

        public Team(string name)
        {
            this.Name = name;
            this.Members = new List<User>();
            this.Creator = "";
        }
    }

}
