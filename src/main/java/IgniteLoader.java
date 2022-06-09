import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.ClientException;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;

public class IgniteLoader {

    public static void main(String[] args) {
        String SERVER_ADDRESS = args[0];
        String CACHE_TABLE_NAME = args[1];
        int ARGUMENT_FOR_CACHE = Integer.parseInt(args[2]);

        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setAddresses(SERVER_ADDRESS);

        try(IgniteClient igniteClient = Ignition.startClient(clientConfiguration)){
            System.out.println("Connected to Ignite on: " + SERVER_ADDRESS);

            ClientCache<Integer, String> cache = igniteClient.cache(CACHE_TABLE_NAME);
            System.out.println("Connected to table: " + CACHE_TABLE_NAME);
            System.out.println("Cache size before operation: " + cache.size());

            long startTime = System.currentTimeMillis();
            String QUERY_RESULT = cache.get(ARGUMENT_FOR_CACHE);
            long finishTime = System.currentTimeMillis();
            long elapsed = finishTime - startTime;

            System.out.println("Result query key " + ARGUMENT_FOR_CACHE + " is a" + QUERY_RESULT);
            System.out.println("Time elapsed query: " + elapsed);
            System.out.println("Cache size after operation: " + cache.size());

        }catch (ClientException ce){
            System.err.println(ce.getMessage());
        }

    }
}
