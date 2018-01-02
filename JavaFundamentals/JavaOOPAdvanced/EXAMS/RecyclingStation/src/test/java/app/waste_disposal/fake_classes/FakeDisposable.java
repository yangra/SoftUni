package app.waste_disposal.fake_classes;

import app.waste_disposal.annotations.Disposable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Disposable
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FakeDisposable {
}
