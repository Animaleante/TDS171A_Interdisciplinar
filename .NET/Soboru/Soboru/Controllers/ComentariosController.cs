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
    public class ComentariosController : Controller
    {
        private EFContext context = new EFContext();

        // GET: Comentarios
        public ActionResult Index()
        {
            ViewBag.ControllerName = "Comentarios";
            ViewBag.ItemIdName = "ComentarioId";
            return View(context.Comentarios.ToList());
        }

        // GET: Comentarios/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Comentario comentario = context.Comentarios.Find(id);
            if (comentario == null)
            {
                return HttpNotFound();
            }
            return View(comentario);
        }

        // GET: Comentarios/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Comentarios/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Comentario comentario)
        {
            if (ModelState.IsValid) {
                comentario.CreatedAt = DateTime.Now;
                comentario.UpdatedAt = DateTime.Now;

                context.Comentarios.Add(comentario);
                context.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(comentario);
        }

        // GET: Comentarios/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Comentario comentario = context.Comentarios.Find(id);
            if (comentario == null)
            {
                return HttpNotFound();
            }
            return View(comentario);
        }

        // POST: Comentarios/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Comentario comentario)
        {
            if (ModelState.IsValid) {
                comentario.UpdatedAt = DateTime.Now;

                context.Entry(comentario).State = EntityState.Modified;
                context.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(comentario);
        }

        // POST: Comentarios/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete()
        {
            int id = int.Parse(Request["ComentarioId"]);

            Comentario comentario = context.Comentarios.Find(id);
            if (comentario != null) {
                context.Comentarios.Remove(comentario);
                context.SaveChanges();

                TempData["Message"] = "Comentario #" + id + " foi removido!";
            } else {
                TempData["Message"] = "Não foi encontrado um Comentario com esse id.";
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
