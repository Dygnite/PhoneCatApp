package modules;

import io.ebean.Model;
import play.Logger;
import play.api.Environment;

import javax.inject.Inject;

public interface LoadPhonesComponent {
}

class LoadPhonesComponentImpl implements LoadPhonesComponent {

    @Inject
    public LoadPhonesComponentImpl(Environment environment) {
        try {
            new PhonesLoader().loadPhones(environment).forEach(Model::save);
            Logger.info("Phones fixtures was loaded to DB");
        } catch (Exception e) {
            Logger.error(String.format("Can't load phones: %s", e.getMessage()));
            System.exit(1);
        }
    }
}
