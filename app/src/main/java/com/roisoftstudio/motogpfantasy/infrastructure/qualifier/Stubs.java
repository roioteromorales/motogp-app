package com.roisoftstudio.motogpfantasy.infrastructure.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier @Retention(RUNTIME) @Target({ ElementType.PARAMETER, ElementType.METHOD })
public @interface Stubs {

}
