using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Soboru.Models
{
    public class ReceitaIngrediente
    {
        [Key]
        public int ReceitaIngredienteId { get; set; }
        public int? ReceitaId { get; set; }
        public int? IngredienteId { get; set; }
        public int? IngredienteMedidaId { get; set; }
        public string SubSessao { get; set; }
        public float QtyReceitaIngrediente { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }

        public Receita Receita { get; set; }
        public Ingrediente Ingrediente { get; set; }
        public IngredienteMedida IngredienteMedida { get; set; }
    }
}