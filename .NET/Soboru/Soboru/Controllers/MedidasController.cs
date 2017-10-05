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
    public class MedidasController : Controller
    {
        private EFContext context = new EFContext();
        private string controllerName = "Medidas";

        // GET: IngredienteMedidas
        public ActionResult Index()
        {
            ViewBag.ControllerName = controllerName;
            return View(context.Medidas.OrderBy(i => i.Nome));
        }

        // GET: IngredienteMedidas/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Medida ingredienteMedida = context.Medidas.Find(id);
            if (ingredienteMedida == null)
            {
                return HttpNotFound();
            }

            ViewBag.ControllerName = controllerName;

            return View(ingredienteMedida);
        }

        // GET: IngredienteMedidas/Create
        public ActionResult Create()
        {
            ViewBag.ControllerName = controllerName;

            return View();
        }

        // POST: IngredienteMedidas/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Medida ingredienteMedida)
        {
            if (ModelState.IsValid) {
                ingredienteMedida.CreatedAt = DateTime.Now;
                ingredienteMedida.UpdatedAt = DateTime.Now;

                context.Medidas.Add(ingredienteMedida);
                context.SaveChanges();
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
            Medida ingredienteMedida = context.Medidas.Find(id);
            if (ingredienteMedida == null)
            {
                return HttpNotFound();
            }

            ViewBag.ControllerName = controllerName;

            return View(ingredienteMedida);
        }

        // POST: IngredienteMedidas/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Medida ingredienteMedida)
        {
            if (ModelState.IsValid) {
                ingredienteMedida.UpdatedAt = DateTime.Now;

                context.Entry(ingredienteMedida).State = EntityState.Modified;
                context.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(ingredienteMedida);
        }

        // POST: IngredienteMedidas/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete()
        {
            int id = int.Parse(Request["IngredienteMedidaId"]);

            Medida ingredienteMedida = context.Medidas.Find(id);
            if (ingredienteMedida != null) {
                context.Medidas.Remove(ingredienteMedida);
                context.SaveChanges();

                TempData["Message"] = "Medida " + ingredienteMedida.Nome + " foi removida!";
            } else {
                TempData["Message"] = "Não foi encontrado uma Medida com esse id.";
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
