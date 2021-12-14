package person.xu.oob.ldapoob;

import com.unboundid.ldap.listener.interceptor.InMemoryInterceptedSearchResult;
import com.unboundid.ldap.listener.interceptor.InMemoryOperationInterceptor;

import java.util.Optional;

public class RecordOperationInterceptor extends InMemoryOperationInterceptor {
    private RecordRepository recordRepository;

    public RecordOperationInterceptor(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }


    @Override
    public void processSearchResult(InMemoryInterceptedSearchResult result) {
        String id = result.getRequest().getBaseDN();
        System.out.printf("receive id %s from %s", id, result.getConnectedAddress());
        Optional<Record> record = recordRepository.findById(id);
        record.ifPresent(r -> {
                    r.setAccess();
                    r.updateReceiveTime();
                    recordRepository.save(r);
                }
        );
    }
}