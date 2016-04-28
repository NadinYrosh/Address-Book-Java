import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/contacts", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String firstname = request.queryParams("firstName");
      String lastname = request.queryParams("lastName");
      Contact newContact = new Contact(firstname, lastname);
      model.put("contacts", Contact.getAll());
      model.put("template", "templates/contacts.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/contacts/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
      model.put("contact", contact);
      model.put("contacts", Contact.getAll());
      model.put("template", "templates/contact-info.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/contacts/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String phoneNumber = request.queryParams("phoneNumber");
      String areaCode = request.queryParams("areaCode");
      String type = request.queryParams("type");
      int birthMonth = Integer.parseInt(request.queryParams("birthMonth"));

      Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
      contact.addBirthMonth(birthMonth);
      Phone newPhone = new Phone (areaCode, phoneNumber, type);
      contact.addPhone(newPhone);
      model.put("contact", contact);
      model.put("contacts", Contact.getAll());
      model.put("template", "templates/full-contact-info.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // post("/contact/:id/fullInfo", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    // }
  }
}
