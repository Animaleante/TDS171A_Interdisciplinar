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
    public class ReceitaIngredientesController : Controller
    {
        private EFContext db = new EFContext();

        // GET: ReceitaIngredientes
        public ActionResult Index()
        {
            return View(db.ReceitaIngredientes.ToList());
        }

        // GET: ReceitaIngredientes/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ReceitaIngrediente receitaIngrediente = db.ReceitaIngredientes.Find(id);
            if (receitaIngrediente == null)
            {
                return HttpNotFound();
            }
            return View(receitaIngrediente);
        }

        // GET: ReceitaIngredientes/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: ReceitaIngredientes/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ReceitaIngredienteId,IdReceita,IdIngrediente,IdMedida,SubSessao,QtyReceitaIngrediente,CreatedAt,UpdatedAt,DeletedAt")] ReceitaIngrediente receitaIngrediente)
        {
            if (ModelState.IsValid)
            {
                db.ReceitaIngredientes.Add(receitaIngrediente);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(receitaIngrediente);
        }

        // GET: ReceitaIngredientes/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ReceitaIngrediente receitaIngrediente = db.ReceitaIngredientes.Find(id);
            if (receitaIngrediente == null)
            {
                return HttpNotFound();
            }
            return View(receitaIngrediente);
        }

        // POST: ReceitaIngredientes/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ReceitaIngredienteId,IdReceita,IdIngrediente,IdMedida,SubSessao,QtyReceitaIngrediente,CreatedAt,UpdatedAt,DeletedAt")] ReceitaIngrediente receitaIngrediente)
        {
            if (ModelState.IsValid)
            {
                db.Entry(receitaIngrediente).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(receitaIngrediente);
        }

        // GET: ReceitaIngredientes/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ReceitaIngrediente receitaIngrediente = db.ReceitaIngredientes.Find(id);
            if (receitaIngrediente == null)
            {
                return HttpNotFound();
            }
            return View(receitaIngrediente);
        }

        // POST: ReceitaIngredientes/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            ReceitaIngrediente receitaIngrediente = db.ReceitaIngredientes.Find(id);
            db.ReceitaIngredientes.Remove(receitaIngrediente);
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
