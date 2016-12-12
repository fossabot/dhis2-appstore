package org.hisp.appstore.api;

import java.util.Date;

public interface IdentifiableObject
{
    int getId();

    void setId( int id );

    String getUid();

    void setUid( String uid );

    Date getCreated();

    void setCreated( Date created );

    void setAutoFields();
}