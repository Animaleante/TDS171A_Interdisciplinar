using System;
using System.ComponentModel.DataAnnotations;

namespace Soboru.Models
{
    public class Comentario
    {
        [Key]
        public int Id { get; set; }
        public int ReceitaId { get; set; }
        public int UsuarioId { get; set; }
        public int BodyComentario { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }

        public Receita Receita { get; set; }
        public Usuario Usuario { get; set; }
    }
}