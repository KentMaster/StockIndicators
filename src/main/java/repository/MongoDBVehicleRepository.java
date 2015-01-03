package repository;

import static org.springframework.data.mongodb.core.query.Criteria.*;
import com.mongodb.*;
import com.zhou.model.Vehicle;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.PreDestroy;
import java.util.List;

@Document(collection = "vehicles")
public class MongoDBVehicleRepository implements VehicleRepository {

    private final MongoTemplate mongo;
    private final String collectionName;

    public MongoDBVehicleRepository(MongoTemplate mongo, String collectionName) {
        this.mongo = mongo;
        this.collectionName = collectionName;
    }

    @Override
    public long count() {
        return mongo.count(null, collectionName);
    }

    @Override
    public void save(Vehicle vehicle) {
        mongo.save(vehicle, collectionName);
    }

    @Override
    public void delete(Vehicle vehicle) {
        mongo.remove(vehicle, collectionName);
    }

    @Override
    public List<Vehicle> findAll() {
        return mongo.findAll(Vehicle.class, collectionName);
    }

//    @Override
//    public Vehicle findByVehicleNo(String vehicleNo) {
//        return mongo.findOne(new Q);
//    }

    @Override
    public Vehicle findByVehicleNo(String vehicleNo) {
        return mongo.findOne(new Query(where("vehicleNo").is(vehicleNo)), Vehicle.class, collectionName);
    }


    @PreDestroy
    public void cleanUp() {
        mongo.execute(new DbCallback<Object>() {
            @Override
            public Object doInDB(DB db) throws MongoException, DataAccessException {
                db.dropDatabase();
                return null;
            }
        });
    }

//    @Override
//    public long count() {
//        return getCollection().count();
//    }
//
//    @Override
//    public void save(Vehicle vehicle) {
//        BasicDBObject query = new BasicDBObject("vehicleNo", vehicle.getVehicleNo());
//        DBObject dbVehicle = transform(vehicle);
//
//        DBObject fromDB = getCollection().findAndModify(query, dbVehicle);
//        if (fromDB == null) {
//            getCollection().insert(dbVehicle);
//        }
//    }
//
//    @Override
//    public void delete(Vehicle vehicle) {
//        BasicDBObject query = new BasicDBObject("vehicleNo", vehicle.getVehicleNo());
//        getCollection().remove(query);
//    }
//
//    @Override
//    public List<Vehicle> findAll() {
//        DBCursor cursor = getCollection().find(null);
//        List<Vehicle> vehicles = new ArrayList<>(cursor.size());
//        for (DBObject dbObject : cursor) {
//            vehicles.add(transform(dbObject));
//        }
//        return vehicles;
//    }
//
//    @Override
//    public Vehicle findByVehicleNo(String vehicleNo) {
//        BasicDBObject query = new BasicDBObject("vehicleNo", vehicleNo);
//        DBObject dbVehicle = getCollection().findOne(query);
//        return transform(dbVehicle);
//    }
//
//    private DBCollection getCollection() {
//        return mongo.getDB(databaseName).getCollection(collectionName);
//    }
//
//    private Vehicle transform(DBObject dbVehicle) {
//        return new Vehicle(
//                (String) dbVehicle.get("vehicleNo"),
//                (String) dbVehicle.get("color"),
//                (int) dbVehicle.get("wheel"),
//                (int) dbVehicle.get("seat"));
//    }
//
//    private DBObject transform(Vehicle vehicle) {
//        BasicDBObject dbVehicle = new BasicDBObject("vehicleNo", vehicle.getVehicleNo())
//                .append("color", vehicle.getColor())
//                .append("wheel", vehicle.getWheel())
//                .append("seat", vehicle.getSeat());
//        return dbVehicle;
//    }
//
//    @PostConstruct
//    public void shutdown() {
//        mongo.getDB(databaseName).dropDatabase();
//    }
}
