using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Soboru.Models
{
    public class Role
    {
        public int RoleId { get; set; }
        public String NomeRole { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime DeletedAt { get; set; }
    }
}