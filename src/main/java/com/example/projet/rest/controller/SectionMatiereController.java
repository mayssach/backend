package com.example.projet.rest.controller;

        import com.example.projet.model.entity.*;
        import com.example.projet.rest.dto.SectionMatiereDto;
        import com.example.projet.service.*;
        import org.modelmapper.ModelMapper;
        import org.modelmapper.TypeToken;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.validation.annotation.Validated;
        import org.springframework.web.bind.annotation.*;
        import java.lang.reflect.Type;
        import java.util.Date;
        import java.util.List;

@RestController
@CrossOrigin
public class SectionMatiereController {
    @Autowired
    private SectionMatiereService sectionMatiereService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MatiereService matiereService;
    @Autowired
    private SectionService sectionService;

    @GetMapping("/Matieres/{idmat}/SectionMatieres")

    public Object SectionMatiereList(@PathVariable Long idNiv) {
        List<SectionMatiere> sectionList = sectionMatiereService.getSectionMatiereList(idNiv);
        Type listType = new TypeToken<List<SectionMatiereDto>>() {}.getType();
        List<SectionMatiereDto> sectionDtos = modelMapper.map(sectionList,listType);
        return ResponseEntity.status(HttpStatus.OK).body(sectionDtos);
    }



    @GetMapping("/SectionMatieres/{idsec}")
    public Object retrieveSectionMatiere(@PathVariable Long idsec) {
        SectionMatiere s = sectionMatiereService.getSectionMatiere(idsec);
        SectionMatiereDto sectionDto = modelMapper.map(s,SectionMatiereDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(sectionDto);
    }


    @PostMapping("/Section/{idsec}/Matiere/{idMat}/SectionMatieres")
    public Object addSectionMatiere(@PathVariable Long idsec,@PathVariable Long idMat,@Validated @RequestBody SectionMatiereDto sectionMatDto) {
        SectionMatiere sectionMat = modelMapper.map(sectionMatDto,SectionMatiere.class);
        Matiere matiere = matiereService.getMatiere(idMat);
        Section section = sectionService.getSection(idsec);
        sectionMat.setSection(section);
        sectionMat.setMatiere(matiere);
        Date dateCreation = new Date();
        sectionMat.setDateCrea(dateCreation);
        sectionMat = sectionMatiereService.AddSectionMatiere(sectionMat);
        sectionMatDto = modelMapper.map(sectionMat, SectionMatiereDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(sectionMatDto);
    }

    @DeleteMapping("/SectionMatieres/{idsec}")
    public Object Delete(@PathVariable Long idsec) {
        sectionMatiereService.DeleteSectionMatiere(idsec);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }


}
