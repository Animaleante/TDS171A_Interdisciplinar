using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Soboru.Models
{
    public class Sexo
    {
        [Key]
        public int SexoId { get; set; }
        [Display(Name = "Nome")]
        public string NomeSexo { get; set; }
    }
}