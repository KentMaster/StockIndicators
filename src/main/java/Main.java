import com.mongodb.MongoClient;
import config.MongoConfiguration;
import model.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import repository.MongoDBVehicleRepository;
import repository.VehicleRepository;

import java.util.List;

public class Main {

    public static final String DB_NAME = "vehicledb";

    public static void main(String[] args) throws Exception {
        // Default mongoclient for localhost and port 27017

        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfiguration.class);
        VehicleRepository repository = ctx.getBean(VehicleRepository.class);
//        MongoClient mongo = new MongoClient();
//
//        VehicleRepository repository = new MongoDBVehicleRepository(mongo, DB_NAME, "vehicles");

        System.out.println("Number of Vehicles: " + repository.count());

        repository.save(new Vehicle("TEM0001", "RED", 4, 4));
        repository.save(new Vehicle("TEM0002", "RED", 4, 4));

        System.out.println("Number of Vehicles: " + repository.count());

        Vehicle v = repository.findByVehicleNo("TEM0001");

//        System.out.println(ToStringBuilder.reflectionToString(v, ToStringStyle.SHORT_PREFIX_STYLE));

        List<Vehicle> vehicleList = repository.findAll();

        System.out.println("Number of Vehicles: " + vehicleList.size());

        for (Vehicle vehicle : vehicleList) {
            repository.delete(vehicle);
        }

        System.out.println("Number of Vehicles: " + repository.count());

//        // Cleanup and close
//        mongo.getDB(DB_NAME).dropDatabase();
//        mongo.close();

        ((AbstractApplicationContext) ctx).close();
    }
}
