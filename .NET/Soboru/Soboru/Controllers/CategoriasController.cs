using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Soboru.Contexts;
using Soboru.Models;

namespace Soboru.Controllers
{
    public class CategoriasController : Controller
    {
        private EFContext context = new EFContext();

        private string controllerName = "Categorias";
        private string categoria = "Cadastro";

        // GET: CategoriaReceitas
        public ActionResult Index()
        {
            ViewBag.ControllerName = controllerName;
            ViewBag.Categoria = categoria;
            return View(context.Categorias.OrderBy(i => i.Nome));
        }

        // GET: CategoriaReceitas/Details/5
        public ActionResult Details(int? id)
        {   
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Categoria categoriaReceita = context.Categorias.Find(id);
            if (categoriaReceita == null)
            {
                return HttpNotFound();
            }

            ViewBag.Categoria = categoria;
            ViewBag.ControllerName = controllerName;

            return View(categoriaReceita);
        }

        // GET: CategoriaReceitas/Create
        public ActionResult Create()
        {
            ViewBag.Categoria = categoria;
            ViewBag.ControllerName = controllerName;

            return View();
        }

        // POST: CategoriaReceitas/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Categoria categoriaReceita)
        {
            if (ModelState.IsValid) {
                categoriaReceita.CreatedAt = DateTime.Now;
                categoriaReceita.UpdatedAt = DateTime.Now;

                context.Categorias.Add(categoriaReceita);
                context.SaveChanges();

                return RedirectToAction("Index");
            }

            return View(categoriaReceita);
        }

        // GET: CategoriaReceitas/Edit/5
        public ActionResult Edit(int? id)
        {
            ViewBag.Categoria = categoria;
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Categoria categoriaReceita = context.Categorias.Find(id);
            if (categoriaReceita == null)
            {
                return HttpNotFound();
            }

            ViewBag.ControllerName = controllerName;

            return View(categoriaReceita);
        }

        // POST: CategoriaReceitas/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Categoria categoriaReceita)
        {
            if (ModelState.IsValid) {
                categoriaReceita.UpdatedAt = DateTime.Now;

                context.Entry(categoriaReceita).State = EntityState.Modified;
                context.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(categoriaReceita);
        }

        // POST: CategoriaReceitas/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete()
        {
            int id = int.Parse(Request["Id"]);

            Categoria categoriaReceita = context.Categorias.Find(id);
            if (categoriaReceita != null) {
                context.Categorias.Remove(categoriaReceita);
                context.SaveChanges();

                TempData["Message"] = "Categoria " + categoriaReceita.Nome + " foi removida!";
            } else {
                TempData["Message"] = "Não foi encontrado uma Categoria com esse id.";
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
