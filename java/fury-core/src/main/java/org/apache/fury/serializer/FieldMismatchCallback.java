package org.apache.fury.serializer;

import org.apache.fury.collection.Tuple2;
import java.lang.reflect.Field;
import java.util.function.Function;

/**
 * Callback interface for handling field mismatch during deserialization.
 */
public interface FieldMismatchCallback {

    /**
     * Called when a field mismatch is detected during deserialization.
     *
     * @param typeName The name of the type being deserialized
     * @param fieldName The name of the field that doesn't currently exist in the class
     *
     * @return A Tuple2 that contains a Field and a Function that takes the deserialized value and returns the field to be set in the Field.
     */
    FieldAdjustment onMismatch(String typeName, String fieldName);


    /**
     * A class to encapsulate a target Field and a method to adjust its value.
     */
    abstract class FieldAdjustment {
        private final Field targetField;

        public FieldAdjustment(Field targetField) {
            this.targetField = targetField;
        }

        public Field getTargetField() {
            return targetField;
        }

        public abstract Object adjustValue(Object deserializedValue);
    }
}
