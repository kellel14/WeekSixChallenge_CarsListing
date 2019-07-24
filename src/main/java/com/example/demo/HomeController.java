package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
@Controller
public class HomeController {
    @Autowired
    CarRepository carRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CarAndCategoryRepository carCategoryRepository;

    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("categories", categoryRepository.findAll());

        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("carCategory", carCategoryRepository);
        return "index";
    }

    @GetMapping("/addcar")
    public String addCar(Model model)
    {
        model.addAttribute("car", new Car());
        model.addAttribute("categories", categoryRepository.findAll());
        return "car";
    }


    @PostMapping("/processcar")
    public String processForm(@ModelAttribute("car") Car car,
                              @RequestParam("carCategory") long... ids)
    {
        // for multiple selection
        for (long id : ids){
            Category category = categoryRepository.findById(id).get();
            CarAndCategory carCategory = new CarAndCategory(category, car);
            carRepository.save(car);
            carCategoryRepository.save(carCategory);
        }
        return "redirect:/";
    }
//        change owner to add vehicle category
//    @GetMapping("/addowner")
//    public String ownerForm(Model model){
//        model.addAttribute("person", new Person());
//        return "owner";
//    }
//
//    @PostMapping("/processowner")
//    public String saveOwner(@Valid Person person, Model model)
//    {
//        personRepository.save(person);
//        return "redirect:/";
//    }

    @PostConstruct
    public void fillTables()
    {
        Category category = new Category();
        category.setCategoryName("Sedan");
        categoryRepository.save(category);

        category = new Category();
        category.setCategoryName("SUV");
       categoryRepository.save(category);

        category= new Category();
        category.setCategoryName("Truck");
        categoryRepository.save(category);
    }

    @RequestMapping("/detail/car/{id}")
    public String showCar(@PathVariable("id") long id, Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("car", carRepository.findById(id).get());
        return "carlist";
    }
    @RequestMapping("/update/car{id}")
    public String updateCar(@PathVariable("id") long id, Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        return "carform";

    }
    @RequestMapping("/delete/car{id}")
    public  String delCar(@PathVariable("id") long id){
        carRepository.deleteById(id);
        return "redirect:/";
    }
}