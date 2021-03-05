package com.github.lramosduarte.fake;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.StreamSupport;

import com.github.lramosduarte.analyser.Analyser;
import com.github.lramosduarte.analyser.AnalyserImp;
import com.github.lramosduarte.data.Attribute;
import com.github.lramosduarte.data.TypesToGenerate;
import com.github.lramosduarte.exception.GenerateValueException;
import com.github.lramosduarte.fake.generator.BoolGenerator;
import com.github.lramosduarte.fake.generator.CharGenerator;
import com.github.lramosduarte.fake.generator.DateTimeGenerator;
import com.github.lramosduarte.fake.generator.Generator;
import com.github.lramosduarte.fake.generator.NumberGenerator;
import com.github.lramosduarte.fake.generator.StringGenerator;
import com.github.lramosduarte.fake.setter.*;
import com.google.common.collect.ImmutableMap;


/**
 * Class that can be used to factory in tests, seeding data,
 * or anything else thats need of a new instance of class with data.
 */
public class FakeDataGenerator {

    private static FakeDataGenerator instance;

    private Analyser analyser;

    private FakeDataGenerator() {
        this.analyser = AnalyserImp.getAnalyser();
    };

    private ImmutableMap<TypesToGenerate, Generator> MAP_GENERATOR = ImmutableMap.<TypesToGenerate, Generator>builder()
        .put(TypesToGenerate.BOOL, new BoolGenerator())
        .put(TypesToGenerate.CHAR, new CharGenerator())
        .put(TypesToGenerate.SMALL_TEXT, new StringGenerator())
        .put(TypesToGenerate.BIG_TEXT, new StringGenerator())
        .put(TypesToGenerate.NUMBER, new NumberGenerator())
        .put(TypesToGenerate.DATETIME, new DateTimeGenerator())
        .build();

    /**
     * Make a fake data to type set in enum, you can to check the types supported inside enum.
     * @param type type identified by enum
     * @param <TypeObject> instance compatible with type
     * @return instance with random value
     * @see TypesToGenerate
     */
    public <TypeObject> TypeObject make(Attribute attribute) {
        return (TypeObject) this.MAP_GENERATOR.get(attribute.type).generate(attribute.getLenght());
    }

    /**
     * Make a new instance of class and generate values to attributes supported.
     * @param cls reference of class
     * @param <ObjectClass> instance of class
     * @return new instance of class with values returned by method
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public <ObjectClass> ObjectClass make(Class<?> cls) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return this.makeAndIgnore(cls, new HashSet<>());
    }

    /**
     * Make a new instance of class and generate values to attributes supported and ignore attributes that pass in set.
     * @param cls reference of class
     * @param attributestoIgnore set of attributes that will be ignored
     * @param <ObjectClass> instance of class
     * @return new instance of class with values returned by method ignoring some fields
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public <ObjectClass> ObjectClass makeAndIgnore(Class<?> cls, Set<String> attributestoIgnore) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Iterable<Attribute> attributes = this.analyser.analyse(cls);
        ObjectClass objectClass = (ObjectClass) cls.newInstance();
        StreamSupport.stream(attributes.spliterator(), false).forEach(a -> {
            if (attributestoIgnore.contains(a.name)) {
                return;
            }
            try {
                this.setAttributeValue(a, objectClass);
            } catch (ReflectiveOperationException ex) {
                throw new GenerateValueException(ex);
            }

        });
        return objectClass;
    }

    private <Instance> void setAttributeValue(Attribute attribute, Instance object) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        if (TypesToGenerate.OBJECT.equals(attribute.type)) {
            new ObjectSetter(FakeDataGenerator.getInstance()).setAttribute(attribute, object);
            return;
        } else if (TypesToGenerate.isShort(attribute.field.getType())) {
            new ShortSetter(FakeDataGenerator.getInstance()).setAttribute(attribute, object);
            return;
        } else if (TypesToGenerate.COLLECTION.equals(attribute.type)) {
            new CollectionSetter(FakeDataGenerator.getInstance()).setAttribute(attribute, object);
            return;
        } else if (TypesToGenerate.DICTIONARY.equals(attribute.type)) {
            new DictionarySetter(FakeDataGenerator.getInstance()).setAttribute(attribute, object);
            return;
        } else if (TypesToGenerate.DATETIME.equals(attribute.type)) {
            new DateTimeSetter(FakeDataGenerator.getInstance()).setAttribute(attribute, object);
            return;
        }
        new DefaultSetter(FakeDataGenerator.getInstance()).setAttribute(attribute, object);
    }

    /**
     * Return instance of FakeGenerator
     * @return
     */
    public static FakeDataGenerator getInstance() {
        if (FakeDataGenerator.instance == null) {
            FakeDataGenerator.instance = new FakeDataGenerator();
        }
        return FakeDataGenerator.instance;
    }

    public static <ObjectClass> ObjectClass fake(Class<ObjectClass> cls) {
        try {
            return FakeDataGenerator.getInstance().make(cls);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }
}
