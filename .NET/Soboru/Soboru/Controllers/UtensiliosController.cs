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
    public class UtensiliosController : Controller
    {
        private EFContext db = new EFContext();

        // GET: Utensilios
        public ActionResult Index()
        {
            ViewBag.ControllerName = "Utensilios";
            ViewBag.ItemIdName = "UtensilioId";

            return View(db.Utensilios.ToList());
        }

        // GET: Utensilios/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Utensilio utensilio = db.Utensilios.Find(id);
            if (utensilio == null)
            {
                return HttpNotFound();
            }
            return View(utensilio);
        }

        // GET: Utensilios/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Utensilios/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "NomeUtensilio")] Utensilio utensilio)
        {
            if (ModelState.IsValid) {
                utensilio.CreatedAt = DateTime.Now;
                utensilio.UpdatedAt = DateTime.Now;

                db.Utensilios.Add(utensilio);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(utensilio);
        }

        // GET: Utensilios/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Utensilio utensilio = db.Utensilios.Find(id);
            if (utensilio == null)
            {
                return HttpNotFound();
            }
            return View(utensilio);
        }

        // POST: Utensilios/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "NomeUtensilio")] Utensilio utensilio)
        {
            if (ModelState.IsValid) {
                utensilio.UpdatedAt = DateTime.Now;

                db.Entry(utensilio).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(utensilio);
        }

        // POST: Utensilios/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Utensilio utensilio = db.Utensilios.Find(id);
            db.Utensilios.Remove(utensilio);
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
