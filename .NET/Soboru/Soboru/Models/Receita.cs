using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Soboru.Models
{
    public class Receita
    {
        [Key]
        public int ReceitaID { get; set; }
        public int IdUsuario { get; set; }
        public string NomeReceita { get; set; }
        public int IdCategoria { get; set; }
        public int Porcao { get; set; }
        public float TempoPreparo { get; set; }
        public string ModoPreparo { get; set; }
        public string ImgPath { get; set; }
        public float PontuacaoMedia { get; set; }
        public int Views { get; set; }
        public int Favs { get; set; }
        public string Slug { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }
    }
}