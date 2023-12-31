package uz.pdp.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarket.entity.Category;
import uz.pdp.pcmarket.payload.ApiResponse;
import uz.pdp.pcmarket.payload.CategoryDto;
import uz.pdp.pcmarket.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PreAuthorize(value = "hasAuthority('READ')")
    @GetMapping
    public List<Category> getCategories(){return categoryService.getCategories();}

    @PreAuthorize(value = "hasAuthority('READ1')")
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Integer id){return categoryService.getCategoryById(id);}



    @PreAuthorize(value = "hasAuthority('CREATE')")
    @PostMapping
    public ResponseEntity<ApiResponse> addCategory(@RequestBody CategoryDto categoryDto){
        ApiResponse apiResponse = categoryService.addCategory(categoryDto);
        return ResponseEntity.ok(apiResponse);
    }


    @PreAuthorize(value = "hasAuthority('UPDATE')")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editCategory(@RequestBody CategoryDto categoryDto,
                                                  @PathVariable Integer id){
        ApiResponse apiResponse = categoryService.editCategory(categoryDto, id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }

    @PreAuthorize(value = "hasAuthority('DELETE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer id){
        ApiResponse apiResponse = categoryService.deleteCategory(id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }
}
