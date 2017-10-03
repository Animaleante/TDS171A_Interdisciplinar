using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace Soboru.Models
{
    public class Ingrediente
    {
        [Key]
        public int IngredienteId { get; set; }
        [Display(Name = "Nome")]
        public string NomeIngrediente { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }
    }
}