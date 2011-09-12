/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package websiteschema.persistence.rdbms;

import java.util.List;
import websiteschema.model.domain.User;

/**
 *
 * @author ray
 */
public interface UserMapper {

    public long getTotalResults();

    public List<User> getUsers();

    public User getUserById();

    public void update(User user);

    public void insert(User user);

    public void delete(User user);
}