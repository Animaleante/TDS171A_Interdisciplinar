using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Soboru.Models
{
    public class PontuacaoReceita
    {
        public int PontuacaoReceitaId { get; set; }
        public int IdReceita { get; set; }
        public int IdUsuario { get; set; }
        public int QtyPontuacaoReceita { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime DeletedAt { get; set; }

    }
}