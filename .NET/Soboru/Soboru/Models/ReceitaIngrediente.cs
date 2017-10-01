using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Soboru.Models
{
    public class ReceitaIngrediente
    {
        public int ReceitaIngredienteId { get; set; }
        public int IdReceita { get; set; }
        public int IdIngrediente { get; set; }
        public int IdMedida { get; set; }
        public string SubSessao { get; set; }
        public float QtyReceitaIngrediente { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime DeletedAt { get; set; }
    }
}