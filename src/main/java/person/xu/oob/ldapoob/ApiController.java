package person.xu.oob.ldapoob;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}/access")
    public boolean isAccess(@PathVariable(name = "id") String id) {
        Optional<Record> record = recordRepository.findById(id);
        if (record.isPresent()) {
            return record.get().isAccess();
        }
        return false;
    }
}
