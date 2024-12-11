package com.spacetravel.spring_15;

import com.spacetravel.spring_15.model.Note;
import com.spacetravel.spring_15.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Метод для відображення списку нотаток
    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.findAll());
        return "note/list";
    }

    // Метод для відображення форми редагування нотатки
    @GetMapping("/edit")
    public String editNoteForm(@RequestParam("id") Long id, Model model) {
        Note note = noteService.findById(id);
        model.addAttribute("note", note);
        return "note/edit";
    }

    // Метод для збереження змін нотатки
    @PostMapping("/edit")
    public String updateNote(@RequestParam Long id, @RequestParam String title, @RequestParam String content) {
        Note note = noteService.findById(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.save(note);
        return "redirect:/note/list";
    }

    // Метод для видалення нотатки
    @PostMapping("/delete")
    public String deleteNote(@RequestParam Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}
