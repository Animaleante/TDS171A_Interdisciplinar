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
    public class PontuacaoReceitasController : Controller
    {
        private EFContext db = new EFContext();

        // GET: PontuacaoReceitas
        public ActionResult Index()
        {
            return View(db.PontuacaoReceitas.ToList());
        }

        // GET: PontuacaoReceitas/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PontuacaoReceita pontuacaoReceita = db.PontuacaoReceitas.Find(id);
            if (pontuacaoReceita == null)
            {
                return HttpNotFound();
            }
            return View(pontuacaoReceita);
        }

        // GET: PontuacaoReceitas/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: PontuacaoReceitas/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "PontuacaoReceitaId,IdReceita,IdUsuario,QtyPontuacaoReceita,CreatedAt,UpdatedAt,DeletedAt")] PontuacaoReceita pontuacaoReceita)
        {
            if (ModelState.IsValid)
            {
                db.PontuacaoReceitas.Add(pontuacaoReceita);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(pontuacaoReceita);
        }

        // GET: PontuacaoReceitas/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PontuacaoReceita pontuacaoReceita = db.PontuacaoReceitas.Find(id);
            if (pontuacaoReceita == null)
            {
                return HttpNotFound();
            }
            return View(pontuacaoReceita);
        }

        // POST: PontuacaoReceitas/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "PontuacaoReceitaId,IdReceita,IdUsuario,QtyPontuacaoReceita,CreatedAt,UpdatedAt,DeletedAt")] PontuacaoReceita pontuacaoReceita)
        {
            if (ModelState.IsValid)
            {
                db.Entry(pontuacaoReceita).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(pontuacaoReceita);
        }

        // GET: PontuacaoReceitas/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PontuacaoReceita pontuacaoReceita = db.PontuacaoReceitas.Find(id);
            if (pontuacaoReceita == null)
            {
                return HttpNotFound();
            }
            return View(pontuacaoReceita);
        }

        // POST: PontuacaoReceitas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            PontuacaoReceita pontuacaoReceita = db.PontuacaoReceitas.Find(id);
            db.PontuacaoReceitas.Remove(pontuacaoReceita);
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
