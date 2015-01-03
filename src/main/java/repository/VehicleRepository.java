package repository;

import com.zhou.model.Vehicle;

import java.util.List;

public interface VehicleRepository {

    public long count();
    public void save(Vehicle vehicle);
    public void delete(Vehicle vehicle);
    public List<Vehicle> findAll();
    public Vehicle findByVehicleNo(String vehicleNo);

}
