using System;
using System.ComponentModel.DataAnnotations;

namespace Soboru.Models
{
    public class ReceitaIngrediente
    {
        [Key]
        public int Id { get; set; }
        public int? ReceitaId { get; set; }
        public int? IngredienteId { get; set; }
        public int? MedidaId { get; set; }
        public string SubSessao { get; set; }
        public float QtyReceitaIngrediente { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }

        public Receita Receita { get; set; }
        public Ingrediente Ingrediente { get; set; }
        public Medida IngredienteMedida { get; set; }
    }
}