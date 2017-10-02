﻿using Soboru.Contexts;
using Soboru.Models;
using System;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web.Mvc;

namespace Soboru.Controllers
{
    public class IngredienteController : Controller
    {
        private EFContext context = new EFContext();

        public ActionResult Index()
        {
            return View(context.Ingredientes.OrderBy(i => i.NomeIngrediente));
        }

        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Ingrediente ingrediente)
        {
            try {
                ingrediente.CreatedAt = DateTime.Now;
                ingrediente.UpdatedAt = DateTime.Now;

                context.Ingredientes.Add(ingrediente);
                context.SaveChanges();

                return RedirectToAction("Index");
            }
            catch {
                return View(ingrediente);
            }
        }

        public ActionResult Edit(int? id)
        {
            if(id == null) {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            Ingrediente ingrediente = context.Ingredientes.Find(id);

            if(ingrediente == null) {
                return HttpNotFound();
            }

            return View(ingrediente);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Ingrediente ingrediente)
        {
            try {
                if(ModelState.IsValid) {
                    context.Entry(ingrediente).State = EntityState.Modified;
                    context.SaveChanges();
                    return RedirectToAction("Index");
                }

                return View(ingrediente);
            }
            catch {
                return View(ingrediente);
            }
        }

        public ActionResult Details(int? id)
        {
            if(id == null) {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            Ingrediente ingrediente = context.Ingredientes.Where(i => i.IngredienteId == id).First();
            if(ingrediente == null) {
                return HttpNotFound();
            }

            return View(ingrediente);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete()
        {
            int id = int.Parse(Request["IngredienteId"]);

            try {
                Ingrediente ingrediente = context.Ingredientes.Find(id);
                if (ingrediente != null) {
                    context.Ingredientes.Remove(ingrediente);
                    context.SaveChanges();

                    TempData["Message"] = "Ingrediente " + ingrediente.NomeIngrediente + " foi removido!";
                } else {
                    TempData["Message"] = "Não foi encontrado um Ingrediente com esse id.";
                }
            } catch {
                TempData["Message"] = "Não foi encontrado um Ingrediente com esse id.";
            }

            return RedirectToAction("Index");
        }
    }
}