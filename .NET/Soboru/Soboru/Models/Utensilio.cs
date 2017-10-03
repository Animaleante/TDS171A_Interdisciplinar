using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Soboru.Models
{
    public class Utensilio
    {
        [Key]
        public int UtensilioId { get; set; }
        [Display(Name = "Nome")]
        public string NomeUtensilio { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }

    }
}