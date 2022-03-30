package person.xu.oob.ldapoob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ldap")
public class ApiController {
    @Autowired
    RecordRepository recordRepository;

    @GetMapping("/register")
    public String registerId() {
        Record record = new Record();
        recordRepository.save(record);
        return record.getId();
    }

    @PostMapping("/{id}/unregister")
    public void unregister(@PathVariable(name = "id") String id) {
        recordRepository.deleteById(id);
    }

    @PostMapping("/{id}/access")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void access(@PathVariable(name = "id") String id) {
        Optional<Record> record = recordRepository.findById(id);
        record.ifPresent(r -> {
                    r.setAccess();
                    r.updateReceiveTime();
                    recordRepository.save(r);
                }
        );
    }

    @GetMapping("/{id}/read")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void read(@PathVariable(name = "id") String id) {
        Optional<Record> record = recordRepository.findById(id);
        record.ifPresent(r -> {
                    r.setAccess();
                    r.updateReceiveTime();
                    recordRepository.save(r);
                }
        );
    }



    @GetMapping("/{id}/access")
    public boolean isAccess(@PathVariable(name = "id") String id) {
        Optional<Record> record = recordRepository.findById(id);
        if (record.isPresent()) {
            return record.get().isAccess();
        }
        return false;
    }
}
