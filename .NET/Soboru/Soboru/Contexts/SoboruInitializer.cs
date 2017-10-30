using Soboru.Models;
using System.Collections.Generic;

namespace Soboru.Contexts
{
    public class SoboruInitializer : System.Data.Entity.DropCreateDatabaseIfModelChanges<EFContext>
    {
        protected override void Seed(EFContext context)
        {
            var sexos = new List<Sexo> {
                new Sexo{Nome="Feminino"},
                new Sexo{Nome="Masculino"},
                new Sexo{Nome="Indefinido"}
            };

            sexos.ForEach(s => context.Sexos.Add(s));
            context.SaveChanges();

            var roles = new List<Role> {
                new Role{Nome="Usuário"},
                new Role{Nome="Admin"}
            };

            roles.ForEach(s => context.Roles.Add(s));
            context.SaveChanges();
        }
    }
}