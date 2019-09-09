package org.elementary.forum.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/test")
public class TestController
{
  private static final Logger log = LogManager.getLogger(TestController.class);

  @RequestMapping(value = "/printNameAndAgeJSP", method = RequestMethod.GET)
  public String aaa(ModelMap model,
                    @RequestParam("name") String userName,
                    @RequestParam("age") Integer userAge)
  {
    model.addAttribute("userName", userName);
    model.addAttribute("userAge", userAge);
    return "test";
  }

  @RequestMapping(value = "/printNameAndAgeRP",
      method = RequestMethod.GET,
      produces = "text/html; charset=utf-8"
  )
  @ResponseBody public String bbb(@RequestParam("name") String userName,
                                  @RequestParam("age") Integer userAge)
  {
    return createResponse(userName, userAge);
  }

  @RequestMapping(value = "/printNameAndAgePV/{userName}/{age}",
      method = RequestMethod.GET,
      produces = "text/html; charset=utf-8"
  )
  @ResponseBody public String ccc(@PathVariable String userName,
                                  @PathVariable("age") Integer userAge)
  {
    return createResponse(userName, userAge);
  }

  private String createResponse(@RequestParam("name") String userName,
                                @RequestParam("age") Integer userAge)
  {
    String result = String.format("Hello %s (%d y.o.) <br>", userName, userAge);
    if (userAge > 30)
    {
      result += "You are sooo old! Come in!";
    }
    else
    {
      result += "You are tooo young! Get out!";
    }
    return result;
  }

  @RequestMapping(path = "/doSmth", method = RequestMethod.GET)
  @ResponseBody public void doSomething()
  {
    log.info("I am trying to do something!");
  }
}
