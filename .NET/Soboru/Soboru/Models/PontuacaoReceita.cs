using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Soboru.Models
{
    public class PontuacaoReceita
    {
        [Key]
        public int PontuacaoReceitaId { get; set; }
        public int ReceitaId { get; set; }
        public int UsuarioId { get; set; }
        public int QtyPontuacaoReceita { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }

        public Receita Receita { get; set; }
        public Usuario Usuario { get; set; }
    }
}