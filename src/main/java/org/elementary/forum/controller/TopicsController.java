package org.elementary.forum.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elementary.forum.dao.jpa.JpaTopicDao;
import org.elementary.forum.entities.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TopicsController
{
  private static final Logger log = LogManager.getLogger();

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public String printWelcome(ModelMap model)
  {
    List<Topic> topics = new JpaTopicDao().loadAll();

    log.info("Total topic loaded = {}", topics.size());

    model.addAttribute("topics", topics);
    return "topics";
  }

}