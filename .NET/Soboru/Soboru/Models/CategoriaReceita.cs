using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Soboru.Models
{
    public class CategoriaReceita
    {
        [Key]
        public int CategoriaReceitaId { get; set; }
        public string NomeCategoria { get; set; }
        public int SuperCategoriaId { get; set; }
        public bool Selecionavel { get; set; }
        public string Slug { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }
    }
}