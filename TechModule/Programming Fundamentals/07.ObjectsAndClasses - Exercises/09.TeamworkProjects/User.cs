using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.TeamworkProjects
{
    public class User
    {
        public string Name { get; set; }
        public Team Team { get; set; }

        public User(string name, Team team)
        {
            this.Name = name;
            this.Team = team;
        }
    }
}
