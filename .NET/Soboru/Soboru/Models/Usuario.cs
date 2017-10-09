using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace Soboru.Models
{
    public class Usuario
    {
        [Key]
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
        public int RoleId { get; set; }
        [DataType(DataType.Date)]
        public DateTime Nasc { get; set; }
        public int SexoId { get; set; }
        public bool NotificacaoEmail { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }

        public virtual ICollection<Receita> Receitas { get; set; }
        public Sexo Sexo { get; set; }
        public Role Role { get; set; }
    }
}