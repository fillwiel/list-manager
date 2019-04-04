package com.wielkopolan.listmanager.controller;

import com.wielkopolan.listmanager.exception.EmptyListException;
import com.wielkopolan.listmanager.exception.NoFormerListElementException;
import com.wielkopolan.listmanager.exception.NoSubsequentListElementException;
import com.wielkopolan.listmanager.facade.ListManagerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller used as API for list management and view provider for main page
 */
@Controller
@SessionAttributes("MessageAttribute")
@RequestMapping("/")
public class WebController {

    private static final String ITEMS_ATTRIBUTE = "items";

    private static final String MESSAGE_ATTRIBUTE = "message";

    private static final String ALERT_CLASS_ATTRIBUTE = "alertClass";

    private static final String REDIRECT_HOME = "redirect:/";

    private static final String HOME_VIEW_NAME = "itemList";

    @Autowired
    private ListManagerFacade listManagerFacade;

    /**
     * Return view with status message
     * @param message optional status message
     * @return view
     */
    @ResponseBody
    @RequestMapping(value = "/",  method = RequestMethod.GET)
    public ModelAndView itemListWithMessage(final Message message){
        ModelAndView modelAndView = new ModelAndView(HOME_VIEW_NAME);
        modelAndView.addObject(ITEMS_ATTRIBUTE, listManagerFacade.findAll());
        if (message != null) {
            modelAndView.addObject(MESSAGE_ATTRIBUTE, message.messageValue);
            modelAndView.addObject(ALERT_CLASS_ATTRIBUTE, message.alertClass);
        }
        return modelAndView;
    }

    /**
     * Api to move {elementId} element up
     * @param elementId element id to be moved
     * @param redir required to forward status message
     * @return redirect to home with status message
     */
    @RequestMapping(value = "item/moveUp/{elementId}", method = RequestMethod.POST)
    public String moveUp(@PathVariable final int elementId, RedirectAttributes redir){
        try {
            listManagerFacade.moveUp(elementId);
            redir.addFlashAttribute(MESSAGE_ATTRIBUTE, Message.MOVED_UP);
        } catch (NoFormerListElementException | EmptyListException e) {
            redir.addFlashAttribute(MESSAGE_ATTRIBUTE, Message.ELEMENT_AT_TOP);
        }
        return REDIRECT_HOME;
    }

    /**
     * Api to move {elementId} element down
     * @param elementId element id to be moved
     * @param redir required to forward status message
     * @return redirect to home with status message
     */
    @RequestMapping(value = "item/moveDown/{elementId}", method = RequestMethod.POST)
    public String moveDown(@PathVariable final int elementId, RedirectAttributes redir){
        try {
            listManagerFacade.moveDown(elementId);
            redir.addFlashAttribute(MESSAGE_ATTRIBUTE, Message.MOVED_DOWN);
        } catch (NoSubsequentListElementException | EmptyListException e) {
            redir.addFlashAttribute(MESSAGE_ATTRIBUTE, Message.ELEMENT_AT_BOTTOM);
        }
        return REDIRECT_HOME;
    }

    /**
     * Api to move {elementId} element to top
     * @param elementId element id to be moved
     * @param redir required to forward status message
     * @return redirect to home with status message
     */
    @RequestMapping(value = "item/moveToTop/{elementId}", method = RequestMethod.POST)
    public String moveToTop(@PathVariable final int elementId, RedirectAttributes redir){
        try {
            listManagerFacade.moveToTop(elementId);
            redir.addFlashAttribute(MESSAGE_ATTRIBUTE, Message.MOVED_MOVED_TO_TOP);
        } catch (NoFormerListElementException | EmptyListException e) {
            redir.addFlashAttribute(MESSAGE_ATTRIBUTE, Message.ELEMENT_AT_TOP);
        }
        return REDIRECT_HOME;
    }

    /**
     * Api to move {elementId} element to bottom
     * @param elementId element id to be moved
     * @param redir required to forward status message
     * @return redirect to home with status message
     */
    @RequestMapping(value = "item/moveToBottom/{elementId}", method = RequestMethod.POST)
    public String moveToBottom(@PathVariable final int elementId, RedirectAttributes redir){
        try {
            listManagerFacade.moveToBottom(elementId);
            redir.addFlashAttribute(MESSAGE_ATTRIBUTE, Message.MOVED_MOVED_TO_BOTTOM);
        } catch (NoSubsequentListElementException | EmptyListException e) {
            redir.addFlashAttribute(MESSAGE_ATTRIBUTE, Message.ELEMENT_AT_BOTTOM);
        }
        return REDIRECT_HOME;
    }
}