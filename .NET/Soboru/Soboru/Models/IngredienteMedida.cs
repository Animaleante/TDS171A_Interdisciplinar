using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Soboru.Models
{
    public class IngredienteMedida
    {
        [Key]
        public int IngredienteMedidaId { get; set; }
        [Display(Name = "Nome")]
        public string NomeMedida { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }
    }
}