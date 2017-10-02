using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Soboru.Models
{
    public class Comentario
    {
        [Key]
        public int ComentarioId { get; set; }
        public int IdReceita { get; set; }
        public int IdUsuario { get; set; }
        public int BodyComentario { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }
    }
}