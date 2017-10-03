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
    public class CategoriaReceitasController : Controller
    {
        private EFContext context = new EFContext();

        // GET: CategoriaReceitas
        public ActionResult Index()
        {
            ViewBag.ControllerName = "CategoriaReceitas";
            ViewBag.ItemIdName = "CategoriaReceitaId";
            return View(context.CategoriaReceitas.OrderBy(i => i.NomeCategoria));
        }

        // GET: CategoriaReceitas/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            CategoriaReceita categoriaReceita = context.CategoriaReceitas.Find(id);
            if (categoriaReceita == null)
            {
                return HttpNotFound();
            }
            return View(categoriaReceita);
        }

        // GET: CategoriaReceitas/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: CategoriaReceitas/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(CategoriaReceita categoriaReceita)
        {
            if (ModelState.IsValid) {
                categoriaReceita.CreatedAt = DateTime.Now;
                categoriaReceita.UpdatedAt = DateTime.Now;

                context.CategoriaReceitas.Add(categoriaReceita);
                context.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(categoriaReceita);
        }

        // GET: CategoriaReceitas/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            CategoriaReceita categoriaReceita = context.CategoriaReceitas.Find(id);
            if (categoriaReceita == null)
            {
                return HttpNotFound();
            }
            return View(categoriaReceita);
        }

        // POST: CategoriaReceitas/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(CategoriaReceita categoriaReceita)
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
            int id = int.Parse(Request["CategoriaReceitaId"]);

            CategoriaReceita categoriaReceita = context.CategoriaReceitas.Find(id);
            if (categoriaReceita != null) {
                context.CategoriaReceitas.Remove(categoriaReceita);
                context.SaveChanges();

                TempData["Message"] = "Categoria " + categoriaReceita.NomeCategoria + " foi removida!";
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
