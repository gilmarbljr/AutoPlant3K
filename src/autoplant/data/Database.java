/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplant.data;

import autoplant.business.domain.Employee;
import autoplant.business.domain.OperationLocation;
import autoplant.business.domain.UnidadeDeCultivo;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gbljunior
 */
public class Database {
    private final Map<String, Employee> employees;
    private final Map<Integer, UnidadeDeCultivo> horta;
    private final OperationLocation operationLocation;

    public Database() {
        this.employees = new HashMap<>();
        this.horta = new HashMap<>();
        this.operationLocation = new OperationLocation(Long.parseLong("1"), "AutoPlant");
        initData();
    }

    public OperationLocation getOperationLocation() {
        return operationLocation;
    }
    
    public Employee getEmployee (String username){
        return employees.get(username);
    }
    
    public UnidadeDeCultivo getUnidadeDeCultivo (Integer id){
        return horta.get(id);
    }
    
    public Collection<UnidadeDeCultivo> getAllUnidadeDeCultivos(){
        return horta.values();
    }
    
    public Integer getNextUCId(){
        return horta.size() + 1;
    }
    
    private void initData(){
        try {
            /*//Users
            Employee employee = new Employee("Gilmar", "Junior", "gbljunior", "123", new Date());
            save(employee);
            
            //Unidades de Cultivo
            int oldID = 0;
            Float meta = Float.parseFloat("1");
            UnidadeDeCultivo uc1 = new UnidadeDeCultivo(++oldID, "Plantinha"+oldID, "Goiaba", meta, meta, meta, meta, meta);
            save(uc1);
            UnidadeDeCultivo uc2 = new UnidadeDeCultivo(++oldID, "Plantinha"+oldID, "Goiaba", meta, meta, meta, meta, meta);
            save(uc2);
            UnidadeDeCultivo uc3 = new UnidadeDeCultivo(++oldID, "Plantinha"+oldID, "Goiaba", meta, meta, meta, meta, meta);
            save(uc3);*/
        } catch (Exception e) {
        }
    }
    
    public void save(Employee employee){
        this.employees.put(employee.getUsername(), employee);
    }
    
    public void save(UnidadeDeCultivo cultivo){
        this.horta.put(cultivo.getId(), cultivo);
    }
    
    public void remove(UnidadeDeCultivo unidadeDeCultivo){
        this.horta.remove(unidadeDeCultivo.getId());
    }
}
