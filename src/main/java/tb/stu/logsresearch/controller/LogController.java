package tb.stu.logsresearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tb.stu.logsresearch.forms.LogForm;
import tb.stu.logsresearch.servises.LogService;

import java.util.List;

@Controller
public class LogController {


    @Autowired
    LogService logService;
    @RequestMapping(value= {"/", "/hello"}, method = RequestMethod.GET)
    String sayHello(Model model) {

        String name = "Helga";
        model.addAttribute("smth", name);
        return "index";
    }
    @RequestMapping(value= {"/search"}, method = RequestMethod.GET)
    String getSearch(Model model) {
        LogForm logForm = new LogForm();
        model.addAttribute("logForm", logForm);
        return "search";
    }



    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String addStudent(Model model,
                             @ModelAttribute("logForm") LogForm logForm){
        String fromForm = logForm.getNameLogFragment();

        System.out.println(fromForm);

       List<String> filtered = logService.extract(fromForm);
       String forpanel = "";
       for(String line: filtered){
           forpanel += line + "<br>";
       }


       logForm.setNamePanel(forpanel.toString());
        model.addAttribute("logForm",logForm);
        return "search";
    }



}
