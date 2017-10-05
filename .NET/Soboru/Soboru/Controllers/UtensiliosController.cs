using Soboru.Contexts;
using Soboru.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;


namespace Soboru.Controllers
{
    public class UtensiliosController : Controller
    {
        private EFContext context = new EFContext();

        // GET: Utensilios
        public ActionResult Index()
        {
            ViewBag.ControllerName = "Utensilios";
            ViewBag.ItemIdName = "UtensilioId";

            return View(context.Utensilios.OrderBy(i => i.Nome));
        }

        // GET: Utensilios/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Utensilio utensilio = context.Utensilios.Find(id);
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
        
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "NomeUtensilio")] Utensilio utensilio)
        {
            if (ModelState.IsValid) {
                utensilio.CreatedAt = DateTime.Now;
                utensilio.UpdatedAt = DateTime.Now;

                context.Utensilios.Add(utensilio);
                context.SaveChanges();
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
            Utensilio utensilio = context.Utensilios.Find(id);
            if (utensilio == null)
            {
                return HttpNotFound();
            }
            return View(utensilio);
        }

        // POST: Utensilios/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Utensilio utensilio)
        {
            if (ModelState.IsValid) {
                utensilio.UpdatedAt = DateTime.Now;

                context.Entry(utensilio).State = EntityState.Modified;
                context.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(utensilio);
        }

        // POST: Utensilios/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete()
        {
            int id = int.Parse(Request["UtensilioId"]);

            Utensilio utensilio = context.Utensilios.Find(id);
            if (utensilio != null)
            {
                utensilio.DeletedAt = DateTime.Now;

                context.Utensilios.Remove(utensilio);
                context.SaveChanges();

                TempData["Message"] = "Utensilio " + utensilio.Nome + " foi removido!";
            }
            else
            {
                TempData["Message"] = "Não foi encontrado um Utensilio com esse id.";
            }

            return RedirectToAction("Index");
        }
    }
}
