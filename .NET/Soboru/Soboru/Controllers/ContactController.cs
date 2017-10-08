using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Soboru.Controllers
{
    public class ContactController : Controller
    {
        private string controllerName = "Contact";
        private string categoria = "Contact";
        // GET: Home
        public ActionResult Index()
        {
            ViewBag.ControllerName = controllerName;
            ViewBag.Categoria = categoria;
            return View();
        }
    }
}