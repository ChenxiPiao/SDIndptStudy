using RestfulApiUploadingByEmail.Models;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web.Http;
using System.Web.Mvc;

namespace RestfulApiUploadingByEmail.Controllers
{
    public class UserController : Controller
    {
        User[] users = new User[] {
            new User { ID = 1, lower_user_name = "asd", user_key = "fgh"},
            new User { ID = 1, lower_user_name = "qwe", user_key = "rty"},
            new User { ID = 1, lower_user_name = "zxc", user_key = "vbn"}
        };

        public IEnumerable<User> GetAllUsers()
        {
            return users;
        }

        public User getUserById(int id)
        {
            var user = users.FirstOrDefault((p) => p.ID == id);
            if (user == null)
            {
                throw new HttpResponseException(HttpStatusCode.NotFound);
            }
            return user;

        }
    }
}