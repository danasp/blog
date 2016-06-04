package org.danila.vereshchakov.controllers;

import org.danila.vereshchakov.models.entities.Feed;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Danila on 04.06.2016.
 */

@Controller
@RequestMapping(value = "/")
public class FeedController {

    @RequestMapping(value = "/feeds")
    public String allFeeds(Model model){
        return null;
    }

    @RequestMapping(value = "/feed/{feedId}")
    public String getFeed(Model model, @PathVariable("feedId") Long feedId){
        return null;
    }

    @RequestMapping(value = "/addFeed")
    public String addFeed(Model model){
        return null;
    }

    @RequestMapping(value = "/saveFeed", method = RequestMethod.POST)
    public String saveFeed(@ModelAttribute Feed feed){
        return null;
    }
}
