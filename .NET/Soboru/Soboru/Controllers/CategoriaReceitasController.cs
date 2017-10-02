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
        private EFContext db = new EFContext();

        // GET: CategoriaReceitas
        public ActionResult Index()
        {
            return View(db.CategoriaReceitas.ToList());
        }

        // GET: CategoriaReceitas/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            CategoriaReceita categoriaReceita = db.CategoriaReceitas.Find(id);
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
        public ActionResult Create([Bind(Include = "CategoriaReceitaId,NomeCategoria,IdSuperCategoria,Selecionavel,Slug,CreatedAt,updatedAt,DeletedAt")] CategoriaReceita categoriaReceita)
        {
            if (ModelState.IsValid)
            {
                db.CategoriaReceitas.Add(categoriaReceita);
                db.SaveChanges();
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
            CategoriaReceita categoriaReceita = db.CategoriaReceitas.Find(id);
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
        public ActionResult Edit([Bind(Include = "CategoriaReceitaId,NomeCategoria,IdSuperCategoria,Selecionavel,Slug,CreatedAt,updatedAt,DeletedAt")] CategoriaReceita categoriaReceita)
        {
            if (ModelState.IsValid)
            {
                db.Entry(categoriaReceita).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(categoriaReceita);
        }

        // GET: CategoriaReceitas/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            CategoriaReceita categoriaReceita = db.CategoriaReceitas.Find(id);
            if (categoriaReceita == null)
            {
                return HttpNotFound();
            }
            return View(categoriaReceita);
        }

        // POST: CategoriaReceitas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            CategoriaReceita categoriaReceita = db.CategoriaReceitas.Find(id);
            db.CategoriaReceitas.Remove(categoriaReceita);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
