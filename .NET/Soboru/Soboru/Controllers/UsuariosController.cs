using Soboru.Contexts;
using Soboru.Models;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web.Mvc;

namespace Soboru.Controllers
{
    public class UsuariosController : Controller
    {
        private EFContext context = new EFContext();

        private string controllerName = "Usuarios";
        private string categoria = "Cadastro";
               

        // GET: Usuarios
        public ActionResult Index()
        {
            ViewBag.ControllerName = controllerName;
            ViewBag.Categoria = categoria;

            return View(context.Usuarios.ToList());
        }

        // GET: Usuarios/Details/5
        public ActionResult Details(int? id)
        {
            ViewBag.Categoria = categoria;
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Usuario usuario = context.Usuarios.Find(id);
            if (usuario == null)
            {
                return HttpNotFound();
            }
            return View(usuario);
        }

        // GET: Usuarios/Create
        public ActionResult Create()
        {
            ViewBag.Categoria = categoria;

            ViewBag.SexoId = new SelectList(context.Sexos.OrderBy(s => s.Nome), "Id", "Nome");

            return View();
        }

        // POST: Usuarios/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Usuario usuario)
        {
            if (ModelState.IsValid)
            {
                usuario.RoleId = context.Roles.First().Id;

                context.Usuarios.Add(usuario);
                context.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(usuario);
        }

        // GET: Usuarios/Edit/5
        public ActionResult Edit(int? id)
        {
            ViewBag.Categoria = categoria;
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Usuario usuario = context.Usuarios.Find(id);
            if (usuario == null)
            {
                return HttpNotFound();
            }
            return View(usuario);
        }

        // POST: Usuarios/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Usuario usuario)
        {
            if (ModelState.IsValid)
            {
                context.Entry(usuario).State = EntityState.Modified;
                context.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(usuario);
        }

        public ActionResult Delete()
        {
            int id = int.Parse(Request["Id"]);

            Usuario usuario = context.Usuarios.Find(id);
            if (usuario != null)
            {
                context.Usuarios.Remove(usuario);
                context.SaveChanges();

                TempData["Message"] = "Usuário " + usuario.Nome + " foi removido!";
            }
            else
            {
                TempData["Message"] = "Não foi encontrado um Usuário com esse id.";
            }

            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                context.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
