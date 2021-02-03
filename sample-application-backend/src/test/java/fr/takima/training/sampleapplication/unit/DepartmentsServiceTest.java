package fr.takima.training.sampleapplication.unit;

import fr.takima.training.sampleapplication.dao.DepartmentDAO;
import fr.takima.training.sampleapplication.entity.Department;
import fr.takima.training.sampleapplication.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class DepartmentsServiceTest {

    @InjectMocks
    private DepartmentService departmentService;

    @Mock
    private DepartmentDAO departmentDAO;

    private Department department = Department.builder().id(1L).name("DepartementTest").build();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetDepartmentByName() {
        when(departmentDAO.getDepartmentByName("DepartmentTest")).thenReturn(department);
        assertEquals(department, departmentDAO.getDepartmentByName("DepartmentTest"));
    }

    @Test
    void testGetDepartmentByNameWithNullValue() {
        assertThrows(IllegalArgumentException.class, () -> departmentService.getByName(null));
    }

    @Test
    void testGetDepartmentByNameWithEmptyValue() {
        assertThrows(IllegalArgumentException.class, () -> departmentService.getByName(""));
    }
}
