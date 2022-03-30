package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.geekbrains.controller.dto.ManufacturerDto;
import ru.geekbrains.service.ManufacturerService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {

    private static final Logger logger = LoggerFactory.getLogger(ManufacturerController.class);

    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService ManufacturerService) {
        this.manufacturerService = ManufacturerService;
    }

    @GetMapping
    public String listPage(@RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size,
                           @RequestParam("sortField") Optional<String> sortField, Model model) {
        model.addAttribute("manufacturers", manufacturerService.findAll(
                page.orElse(1) - 1,
                size.orElse(5),
                sortField.filter(fld -> !fld.isBlank()).orElse("id")));
            return "manufacturers";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("activePage", "manufacturer");
    }

    @GetMapping("/new")
    public String newManufacturerForm(Model model) {
        logger.info("New Manufacturer page requested");

        model.addAttribute("manufacturer", new ManufacturerDto());
        return "manufacturer_form";
    }

    @GetMapping("/{id}")
    public String editManufacturer(@PathVariable("id") Long id, Model model) {
        logger.info("Edit Manufacturer page requested");

        model.addAttribute("manufacturer", manufacturerService.findById(id)
                .orElseThrow(() -> new NotFoundException("Manufacturer not found")));
        return "manufacturer_form";
    }

    @PostMapping
    public String update(@Valid @ModelAttribute("manufacturer") ManufacturerDto Manufacturer, BindingResult result) {
        logger.info("Saving manufacturer");

        if (result.hasErrors()) {
            return "manufacturer_form";
        }
        manufacturerService.save(Manufacturer);
        return "redirect:/manufacturer";
    }

    @DeleteMapping("/{id}")
    public String deleteManufacturer(@PathVariable("id") Long id) {
        logger.info("Deleting Manufacturer with id {}", id);

        manufacturerService.deleteById(id);
        return "redirect:/manufacturer";
    }

    @ExceptionHandler
    public ModelAndView notFoundExceptionHandler(NotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("not_found");
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }
}
