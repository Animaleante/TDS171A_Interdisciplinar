using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Soboru.Models
{
    public class IngredienteMedida
    {
        public int IngredienteMedidaId { get; set; }
        public string NomeTag { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime DeletedAt { get; set; }
    }
}