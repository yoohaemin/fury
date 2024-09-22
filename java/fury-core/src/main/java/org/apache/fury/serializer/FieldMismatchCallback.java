package org.apache.fury.serializer;

import org.apache.fury.resolver.FieldResolver;

/**
 * Callback interface for handling field mismatch during deserialization.
 */
public interface FieldMismatchCallback {

    /**
     * Called when a field mismatch is detected during deserialization.
     *
     * @param fieldInfo Information about the field being deserialized
     * @param deserializedValue The original value read from the serialized data
     * @return The value to be used for the field, or null if the field should be skipped
     *
     * @throws ClassCastException if the return value is not the type of the field
     */
    Object onMismatch(FieldResolver.FieldInfo fieldInfo, Object deserializedValue);
}
