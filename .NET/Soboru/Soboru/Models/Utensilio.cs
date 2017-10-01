using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Soboru.Models
{
    public class Utensilio
    {
        public int ItensilioId { get; set; }
        public string NomeUtensilio { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime DeletedAt { get; set; }

    }
}