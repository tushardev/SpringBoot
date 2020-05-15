package com.jpa;

import com.jpa.entity.Author;
import com.jpa.entity.CD;
import com.jpa.entity.MusicInstitute;
import com.jpa.entity.Musician;
import com.jpa.repository.AuthorRepository;
import com.jpa.repository.CDRepository;
import com.jpa.repository.MusicInstituteRepository;
import com.jpa.repository.MusicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AppService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CDRepository cdRepository;

    @Autowired
    private MusicInstituteRepository instituteRepository;

    @Autowired
    private MusicianRepository musicianRepository;

    public void createAuthor() {

        Author author = new Author();
        author.setFirstName("J K");
        author.setLastName("Rowling");
        author.setDateOfBirth(LocalDateTime.now());

        authorRepository.save(author);
    }

    public void createCD() {

        CD cd = new CD();
        cd.setTitle("Twilight");
        cd.setDescription("Twilight OST Album");
        cd.setDuration(90L);
        cd.setUnitCost(100.00);
        cd.setGenre("Romantic Jazz");

        List<Musician> musicians = new ArrayList<>();

        Musician musician1 = new Musician();
        musician1.setFirstName("Paramore");
        musician1.setLastName("Band");
        musician1.setDateOfBirth(LocalDateTime.of(2000, 05, 28, 06, 30));
        musician1.setPrimaryInstrument("Guitar");

        Musician musician2 = new Musician();
        musician2.setFirstName("Muse");
        musician2.setLastName("Band");
        musician2.setDateOfBirth(LocalDateTime.of(2008, 11, 04, 10, 25));
        musician2.setPrimaryInstrument("Piano");

        musicians.add(musician1);
        musicians.add(musician2);

        cd.setMusicians(musicians);

        cdRepository.save(cd);
    }

    public CD getCd(Long cdId) {
        Optional<CD> cd = cdRepository.findById(cdId);
        return cd.orElse(null);
    }
    public Musician getMusician(Long cdId) {
        Optional<Musician> musicians = musicianRepository.findById(cdId);
        return musicians.orElse(null);
    }


    @Transactional(Transactional.TxType.REQUIRED)
    public void createInstitute() {
        MusicInstitute institute = new MusicInstitute();

        institute.setInstituteName("Oxford Studio");
        institute.setInstituteAdd("London");

        List<Musician> musicians = musicianRepository.findAllById(Arrays.asList(1L,2L));

        musicians.forEach(s -> s.setMusicInstitute(institute));

        institute.setMusicians(musicians);

        instituteRepository.save(institute);
    }

    public void addCDforMusician() {

        Musician musician = musicianRepository.findById(2L).get();
        CD cd = cdRepository.findById(1L).get();

        musician.getCds().add(cd);

        musicianRepository.save(musician);
    }

    public void addNewCD() {
        CD cd = new CD();
        cd.setTitle("After Laughter");
        cd.setDescription("Paramore Album");
        cd.setDuration(60L);
        cd.setUnitCost(200.00);
        cd.setGenre("Hard Rock");

        cdRepository.save(cd);
    }
}

/**** Adding CD along with Musicians will not add data in mapping table as owner of the relation is Musician Entity.
 Hence when we add CD for Musicians - mapping records will be inserted in Mapping table.
 ***/