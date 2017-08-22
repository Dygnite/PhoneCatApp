package modules;

import play.api.Configuration;
import play.api.Environment;
import play.api.inject.Binding;
import play.api.inject.Module;
import scala.collection.Seq;

public class LoadPhonesModule extends Module {
    @Override
    public Seq<Binding<?>> bindings(Environment environment, Configuration configuration) {
        return seq(
                bind(LoadPhonesComponent.class).to(LoadPhonesComponentImpl.class)
        );
    }
}
