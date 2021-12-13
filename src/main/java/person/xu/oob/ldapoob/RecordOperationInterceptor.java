package person.xu.oob.ldapoob;

import com.unboundid.ldap.listener.interceptor.InMemoryInterceptedSearchResult;
import com.unboundid.ldap.listener.interceptor.InMemoryOperationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RecordOperationInterceptor extends InMemoryOperationInterceptor {
    @Autowired
    RecordRepository recordRepository;

    @Override
    public void processSearchResult(InMemoryInterceptedSearchResult result) {
        String id = result.getRequest().getBaseDN();
        Optional<Record> record = recordRepository.findById(id);
        record.ifPresent(r -> {
                    r.setAccess();
                    recordRepository.save(r);
                    System.out.println("update " + id);
                }
        );
    }
}