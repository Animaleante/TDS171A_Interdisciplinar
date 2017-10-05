using System;
using System.ComponentModel.DataAnnotations;

namespace Soboru.Models
{
    public class Categoria
    {
        [Key]
        public int Id { get; set; }
        public string Nome { get; set; }
        public int SuperCategoriaId { get; set; }
        public bool Selecionavel { get; set; }
        public string Slug { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }
    }
}