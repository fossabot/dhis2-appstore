package org.hisp.appstore.api;

import org.hisp.appstore.api.domain.*;
import org.hisp.appstore.util.WebMessageException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by zubair on 01.12.16.
 */
public interface AppStoreService
{
    App getApp(int id );

    App getApp( String uid );

    List<App> get( AppQueryParameters queryParameters );

    List<App> getAllApps( );

    List<App> getAllAppsByStatus( AppStatus status );

    List<App> getAllAppsByOwner( String owner );

    void updateApp( App app );

    int saveApp( App app );

    void setAppApproval( App app, AppStatus status);

    void removeReviewFromApp( App app, Review review );

    void addReviewToApp( App app, Review review );

    void setAppLogo( App app, ImageResource imageResource );

    AppVersion addVersionToApp( App app, AppVersion version, MultipartFile file, ResourceType resourceType ) throws WebMessageException, IOException;

    ImageResource addImagesToApp( App app, ImageResource imageResource, MultipartFile file, ResourceType resourceType ) throws WebMessageException, IOException;

    void removeVersionFromApp( App app, AppVersion version, ResourceType resourceType ) throws WebMessageException;

    void removeImageFromApp( App app, ImageResource imageResource, ResourceType resourceType );

    void uploadApp(  App app, MultipartFile file, MultipartFile imageFile ) throws WebMessageException, IOException;

    void removeApp( App app );

    AppQueryParameters getParameterFromUrl( AppType type, String reqDhisVersion );
}
