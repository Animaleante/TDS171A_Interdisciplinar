using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Soboru.Models
{
    public class Ingrediente
    {
        public int IngredienteId { get; set; }
        public string NomeIngrediente { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }
    }
}