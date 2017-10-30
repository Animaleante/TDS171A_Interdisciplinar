using System;
using System.ComponentModel.DataAnnotations;

namespace Soboru.Models
{
    public class Receita
    {
        [Key]
        public int Id { get; set; }
        public string Nome { get; set; }
        public int? UsuarioId { get; set; }
        public int CategoriaId { get; set; }
        public int Porcao { get; set; }
        public float TempoPreparo { get; set; }
        public string ModoPreparo { get; set; }
        public string ImgPath { get; set; } = "";
        public float PontuacaoMedia { get; set; } = 0;
        public int Views { get; set; } = 0;
        public int Favs { get; set; } = 0;
        public string Slug { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }

        public Usuario Usuario { get; set; }
        public Categoria CategoriaReceita { get; set; }
    }
}