package task.opencodetesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import task.opencodetesttask.entities.FormPassage;
import task.opencodetesttask.service.FormPassageService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/formPassages")
public class FormPassageController {

    private final FormPassageService formPassageService;

    @Autowired
    public FormPassageController(FormPassageService formPassageService) {
        this.formPassageService = formPassageService;
    }

    @GetMapping
    public List<FormPassage> getAll() {
        return formPassageService.findAll();
    }

    @GetMapping(value = "/{id}")
    public FormPassage findById(@PathVariable("id") Long id) {
        return formPassageService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@RequestBody FormPassage resource) {
        Objects.requireNonNull(resource);
        return formPassageService.save(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") long id, @RequestBody FormPassage resource) {
        resource.setId(id);
        formPassageService.save(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        formPassageService.deleteById(id);
    }
}
