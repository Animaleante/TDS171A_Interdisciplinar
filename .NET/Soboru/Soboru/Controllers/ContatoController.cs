using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Soboru.Controllers
{
    public class ContatoController : Controller
    {
        private string controllerName = "Contato";
        private string categoria = "Contato";
        // GET: Home
        public ActionResult Index()
        {
            ViewBag.ControllerName = controllerName;
            ViewBag.Categoria = categoria;
            return View();
        }
    }
}