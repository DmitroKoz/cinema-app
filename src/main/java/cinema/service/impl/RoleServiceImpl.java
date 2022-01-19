package cinema.service.impl;

import cinema.dao.RoleDao;
import cinema.exception.DataProcessingException;
import cinema.model.Role;
import cinema.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getByName(String name) {
        return roleDao.getByName(name).orElseThrow(
                () -> new DataProcessingException("Role with name " + name + " not found"));
    }
}
