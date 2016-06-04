package org.danila.vereshchakov.controllers;

import org.danila.vereshchakov.models.entities.Comment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Danila on 04.06.2016.
 */

@RequestMapping(value = "/comments")
public class CommentController {

    @RequestMapping(value = "/{feedId}")
    public String allComments(Model model, @PathVariable("feedId") Long feedId) {
        return null;
    }

    public String addComment(@ModelAttribute Comment comment) {
        return null;
    }
}
