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
    public class IngredienteMedidasController : Controller
    {
        private EFContext db = new EFContext();

        // GET: IngredienteMedidas
        public ActionResult Index()
        {
            return View(db.IngredienteMedidas.ToList());
        }

        // GET: IngredienteMedidas/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            IngredienteMedida ingredienteMedida = db.IngredienteMedidas.Find(id);
            if (ingredienteMedida == null)
            {
                return HttpNotFound();
            }
            return View(ingredienteMedida);
        }

        // GET: IngredienteMedidas/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: IngredienteMedidas/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IngredienteMedidaId,NomeTag,CreatedAt,UpdatedAt,DeletedAt")] IngredienteMedida ingredienteMedida)
        {
            if (ModelState.IsValid)
            {
                db.IngredienteMedidas.Add(ingredienteMedida);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(ingredienteMedida);
        }

        // GET: IngredienteMedidas/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            IngredienteMedida ingredienteMedida = db.IngredienteMedidas.Find(id);
            if (ingredienteMedida == null)
            {
                return HttpNotFound();
            }
            return View(ingredienteMedida);
        }

        // POST: IngredienteMedidas/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IngredienteMedidaId,NomeTag,CreatedAt,UpdatedAt,DeletedAt")] IngredienteMedida ingredienteMedida)
        {
            if (ModelState.IsValid)
            {
                db.Entry(ingredienteMedida).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(ingredienteMedida);
        }

        // GET: IngredienteMedidas/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            IngredienteMedida ingredienteMedida = db.IngredienteMedidas.Find(id);
            if (ingredienteMedida == null)
            {
                return HttpNotFound();
            }
            return View(ingredienteMedida);
        }

        // POST: IngredienteMedidas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            IngredienteMedida ingredienteMedida = db.IngredienteMedidas.Find(id);
            db.IngredienteMedidas.Remove(ingredienteMedida);
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
