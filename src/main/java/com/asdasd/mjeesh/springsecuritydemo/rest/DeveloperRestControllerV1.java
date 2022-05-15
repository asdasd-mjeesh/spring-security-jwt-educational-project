package com.asdasd.mjeesh.springsecuritydemo.rest;

import com.asdasd.mjeesh.springsecuritydemo.model.Developer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {
    private List<Developer> developers;

    public DeveloperRestControllerV1() {
        developers = new ArrayList<>();
        developers.addAll(List.of(
                new Developer(1L, "Ivan", "Ivanov"),
                new Developer(2L, "Sergey", "Sergeev"),
                new Developer(3L, "Petr", "Petrov")
        ));
    }

    @GetMapping("")
    public List<Developer> getAll() {
        return developers;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public Developer getById(@PathVariable Long id) {
        return developers.stream()
                .filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('developers:write')")
    public Developer create(@RequestBody Developer developer) {
        developers.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void deleteById(@PathVariable Long id) {
        developers.removeIf(developer -> developer.getId().equals(id));
    }

}
