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
    public class TagsController : Controller
    {
        private EFContext context = new EFContext();

        private string controllerName = "Tags";
        private string categoria = "Cadastro";
        // GET: Tags
        public ActionResult Index()
        {
            ViewBag.ControllerName = controllerName;
            ViewBag.Categoria = categoria;
            ViewBag.ItemIdName = "IngredienteId";

            return View(context.Tags.OrderBy(i => i.Nome));
        }

        // GET: Tags/Details/5
        public ActionResult Details(int? id)
        {   
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Tag tag = context.Tags.Find(id);
            if (tag == null)
            {
                return HttpNotFound();
            }
            ViewBag.Categoria = categoria;
            ViewBag.ControllerName = controllerName;
            return View(tag);
        }

        // GET: Tags/Create
        public ActionResult Create()
        {
            ViewBag.Categoria = categoria;
            ViewBag.ControllerName = controllerName;
            return View();
        }

        // POST: Tags/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Tag tag)
        {
            if (ModelState.IsValid)
            {
                tag.CreatedAt = DateTime.Now;
                tag.UpdatedAt = DateTime.Now;

                context.Tags.Add(tag);
                context.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(tag);
        }

        // GET: Tags/Edit/5
        public ActionResult Edit(int? id)
        {
            ViewBag.Categoria = categoria;
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Tag tag = context.Tags.Find(id);
            if (tag == null)
            {
                return HttpNotFound();
            }
            return View(tag);
        }

        // POST: Tags/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Tag tag)
        {
            if (ModelState.IsValid)
            {
                tag.UpdatedAt = DateTime.Now;

                context.Entry(tag).State = EntityState.Modified;
                context.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(tag);
        }

        // POST: Tags/Delete/
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete()
        {
            int id = int.Parse(Request["TagId"]);
            Tag tag = context.Tags.Find(id);
            context.Tags.Remove(tag);
            context.SaveChanges();
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
