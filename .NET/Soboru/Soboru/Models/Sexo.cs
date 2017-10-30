using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Soboru.Models
{
    [Table("Sexos")]
    public class Sexo
    {
        [Key]
        public int Id { get; set; }
        public string Nome { get; set; }
    }
}