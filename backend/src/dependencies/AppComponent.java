package dependencies;

import javax.inject.Singleton;
import dagger.Component;
import lambda.functions.CreateEntry;
import lambda.functions.CreateUser;
import lambda.functions.GetEntry;
import lambda.functions.GetUser;

@Singleton
@Component(modules = {DaoModule.class})
public interface AppComponent {
    CreateEntry provideCreateEntry();
    CreateUser provideCreateUser();
    GetEntry provideGetEntry();
    GetUser provideGetUser();
}
