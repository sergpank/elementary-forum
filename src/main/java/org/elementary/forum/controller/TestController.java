package org.elementary.forum.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/test")
public class TestController
{
  private static final Logger log = LogManager.getLogger(TestController.class);

  @RequestMapping(value = "/printNameAndAge", method = RequestMethod.GET)
  @ResponseBody public String aaa(@RequestParam("name") String userName,
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
