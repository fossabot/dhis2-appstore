package org.hisp.appstore.service;

import org.hisp.appstore.api.domain.User;
import org.hisp.appstore.api.UserService;
import org.hisp.appstore.api.UserStore;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zubair on 02.12.16.
 */
@Transactional
public class DefaultUserService implements
        UserService, UserDetailsService
{
    // -------------------------------------------------------------------------
    // Dependencies
    // -------------------------------------------------------------------------

    private UserStore userStore;

    public void setUserStore( UserStore userStore )
    {
        this.userStore = userStore;
    }

    // -------------------------------------------------------------------------
    // Implementation methods
    // -------------------------------------------------------------------------

    @Override
    public UserDetails loadUserByUsername( String s ) throws UsernameNotFoundException
    {

        User user = userStore.getUserByUsername( s ) ;

        if ( user == null )
        {
            throw new UsernameNotFoundException( "User not found" );
        }

        return user.getUserDetails();
    }

    @Override
    public int addUser( User user )
    {
        return userStore.save( user );
    }

    @Override
    public void deleteUser( User user )
    {
        userStore.delete( user );
    }

    @Override
    public void updateUser( User user )
    {
        userStore.update( user );
    }

    @Override
    public User getUser( int id )
    {
        return userStore.get( id );
    }
}