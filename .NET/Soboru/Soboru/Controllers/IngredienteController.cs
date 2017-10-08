using System;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web.Mvc;
using Soboru.Contexts;
using Soboru.Models;

namespace Soboru.Controllers
{
    public class IngredientesController : Controller
    {
        private EFContext context = new EFContext();

        private string controllerName = "Ingredientes";
        private string categoria = "Cadastro";

        public ActionResult Index()
        {
            ViewBag.ControllerName = controllerName;
            ViewBag.Categoria = categoria;
            return View(context.Ingredientes.OrderBy(i => i.Nome));
        }

        public ActionResult Details(int? id)
        {
            if (id == null) {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            //Ingrediente ingrediente = context.Ingredientes.Where(i => i.IngredienteId == id).First();
            Ingrediente ingrediente = context.Ingredientes.Find(id);
            if (ingrediente == null) {
                return HttpNotFound();
            }

            ViewBag.Categoria = categoria;
            ViewBag.ControllerName = controllerName;
            return View(ingrediente);
        }

        public ActionResult Create()
        {
            ViewBag.Categoria = categoria;
            ViewBag.ControllerName = controllerName;
            return View();
        }

        // POST: Ingredientes/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Ingrediente ingrediente)
        {
            if (ModelState.IsValid) {
                ingrediente.CreatedAt = DateTime.Now;
                ingrediente.UpdatedAt = DateTime.Now;

                context.Ingredientes.Add(ingrediente);
                context.SaveChanges();

                return RedirectToAction("Index");
            }

            return View(ingrediente);
        }

        public ActionResult Edit(int? id)
        {
            ViewBag.Categoria = categoria;
            if (id == null) {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            Ingrediente ingrediente = context.Ingredientes.Find(id);

            if(ingrediente == null) {
                return HttpNotFound();
            }

            ViewBag.ControllerName = controllerName;
            return View(ingrediente);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Ingrediente ingrediente)
        {
            if(ModelState.IsValid) {
                ingrediente.UpdatedAt = DateTime.Now;

                context.Entry(ingrediente).State = EntityState.Modified;
                context.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(ingrediente);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete()
        {
            int id = int.Parse(Request["Id"]);
            
            Ingrediente ingrediente = context.Ingredientes.Find(id);
            if (ingrediente != null) {
                context.Ingredientes.Remove(ingrediente);
                context.SaveChanges();

                TempData["Message"] = "Ingrediente " + ingrediente.Nome + " foi removido!";
            } else {
                TempData["Message"] = "Não foi encontrado um Ingrediente com esse id.";
            }

            return RedirectToAction("Index");
        }
    }
}