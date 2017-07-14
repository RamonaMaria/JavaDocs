package ro.teamnet.zth.api.em;

import ro.teamnet.zth.appl.domain.dao.Employee;

import java.util.List;

/**
 * Created by Ramona.Raducu on 7/14/2017.
 */
public
interface SearchEmployee {
    List<Employee> findEmployee(String department);
}
