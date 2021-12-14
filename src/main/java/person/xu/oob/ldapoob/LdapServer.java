package person.xu.oob.ldapoob;

import com.unboundid.ldap.listener.InMemoryDirectoryServer;
import com.unboundid.ldap.listener.InMemoryDirectoryServerConfig;
import com.unboundid.ldap.listener.InMemoryListenerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.net.InetAddress;

@Component
public class LdapServer implements ApplicationRunner {
    @Autowired
    RecordRepository recordRepository;

    @Autowired
    Properties properties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        InMemoryDirectoryServerConfig config = new InMemoryDirectoryServerConfig("dc=example,dc=com");

        config.setListenerConfigs(new InMemoryListenerConfig(
                "listen",
                InetAddress.getByName(properties.getIp()),
                properties.getPort(),
                ServerSocketFactory.getDefault(),
                SocketFactory.getDefault(),
                (SSLSocketFactory) SSLSocketFactory.getDefault()));

        config.addInMemoryOperationInterceptor(new RecordOperationInterceptor(recordRepository));
        InMemoryDirectoryServer ds = new InMemoryDirectoryServer(config);
        System.out.printf("Running ldap server on %s:%d ", properties.getIp(), properties.getPort());
        ds.startListening();
//        ds.shutDown(true);

    }
}