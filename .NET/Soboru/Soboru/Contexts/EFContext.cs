using Soboru.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Data.Entity.ModelConfiguration.Conventions;

namespace Soboru.Contexts
{
    public class EFContext : DbContext
    {
        public EFContext() : base("Asp_Net_MVC_CS") { }

        public DbSet<Ingrediente> Ingredientes { get; set; }
        public DbSet<Tag> Tags { get; set; }
        public DbSet<Utensilio> Utensilios { get; set; }
        public DbSet<Sexo> Sexos { get; set; }
        public DbSet<Role> Roles { get; set; }
        public DbSet<IngredienteMedida> IngredienteMedidas { get; set; }
        public DbSet<Usuario> Usuarios { get; set; }

        public DbSet<CategoriaReceita> CategoriaReceitas { get; set; }
        public DbSet<Receita> Receitas { get; set; }
        public DbSet<ReceitaIngrediente> ReceitaIngredientes { get; set; }
        public DbSet<Comentario> Comentarios { get; set; }
        public DbSet<PontuacaoReceita> PontuacaoReceitas { get; set; }
        //Linha que evita a pluralização em inglês.
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
        moldelBuilder.Conventions.Remove<PluralizingTableNameConventon>();
        }
    }
}
